package com.worldnettps.simplebanking.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.worldnettps.simplebanking.dto.DepositDTO;
import com.worldnettps.simplebanking.dto.ReceiptDTO;
import com.worldnettps.simplebanking.dto.TransferDTO;
import com.worldnettps.simplebanking.exceptions.BusinessException;
import com.worldnettps.simplebanking.model.Account;
import com.worldnettps.simplebanking.model.Balance;
import com.worldnettps.simplebanking.model.Transaction;
import com.worldnettps.simplebanking.model.TransactionDeposit;
import com.worldnettps.simplebanking.model.TransactionTransfer;
import com.worldnettps.simplebanking.model.enums.TransactionType;
import com.worldnettps.simplebanking.repository.DepositRepository;
import com.worldnettps.simplebanking.repository.TransactionRepository;
import com.worldnettps.simplebanking.repository.TransferRepository;
import com.worldnettps.simplebanking.util.MessageEnum;

@Component
public class TransactionService extends AbstractService {
	
	@Autowired
	private DepositRepository depositRepository;

	@Autowired
	private TransferRepository transferRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	public List<ReceiptDTO> getAllTransactions(Long accountNumber) {

		List<? extends Transaction> allTransaction = transactionRepository.getAllTransaction(accountNumber);
		List<ReceiptDTO> receipts = new ArrayList<>();
		
		allTransaction.forEach(transaction -> {
			if (transaction.getType().equals(TransactionType.DEPOSIT)){
				receipts.add(new ReceiptDTO((TransactionDeposit) transaction));
			} else if (transaction.getType().equals(TransactionType.TRANSFER)){
				receipts.add(new ReceiptDTO((TransactionTransfer) transaction, accountNumber, true));
			}
		});
		
		return receipts;
	}
	
	/**
	 * Make de amount deposit in account
	 * @param depositDTO - {@link DepositDTO}
	 * @return transaction - {@link TransactionDeposit}
	 */
	public ReceiptDTO makeDeposit(DepositDTO depositDTO) {
		if (BigDecimal.ZERO.compareTo(depositDTO.getAmount()) >= 0) {
			throw new BusinessException(MessageEnum.AMOUNT_INVALID);
		}
		
		Account account = getAccountByAccountNumber(depositDTO.getAccountNumber());
		Balance actualBalance = account.getActualBalance();
		
		// Create the deposit transaction
		TransactionDeposit transactionDeposit = TransactionDeposit.depositBuilder()
				.account(account)
				.amount(depositDTO.getAmount())
				.dateTransaction(depositDTO.getDate())
				.type(TransactionType.DEPOSIT)
				.build();

		// Create new balance
		Balance newBalance = Balance.builder()
				.finalBalance(actualBalance.getFinalBalance().add(depositDTO.getAmount()))
				.inicialBalance(actualBalance.getFinalBalance())
				.transaction(transactionDeposit)
				.accountNumber(account.getNumber())
				.build();
		
		// Update new balance in account
		account.setActualBalance(newBalance);
		
		TransactionDeposit saveDeposit = depositRepository.save(transactionDeposit);
		return new ReceiptDTO(saveDeposit);
	}
	
	/**
	 * Make de amount deposit in account
	 * @param depositDTO - {@link DepositDTO}
	 * @return transaction - {@link TransactionDeposit}
	 */
	public ReceiptDTO transferFunds(TransferDTO transferDTO) {
		
		Account accountFrom = getAccountByAccountNumber(transferDTO.getAccountNumber());
		Balance actualBalanceFrom = accountFrom.getActualBalance();

		validateTransferRules(transferDTO, actualBalanceFrom);
		
		Account accountTo = getAccountByAccountNumber(transferDTO.getAccountNumberTo());
		Balance actualBalanceTo = accountTo.getActualBalance();
		
		// Create the transfer transaction
		TransactionTransfer transactionTransfer= TransactionTransfer.transferBuilder()
				.account(accountFrom)
				.amount(transferDTO.getAmount())
				.dateTransaction(transferDTO.getDate())
				.type(TransactionType.TRANSFER)
				.accountFrom(accountTo)
				.build();

		// Create new balance in account FROM
		Balance newBalanceFrom = Balance.builder()
				.inicialBalance(actualBalanceFrom.getFinalBalance())
				.finalBalance(actualBalanceFrom.getFinalBalance().subtract(transferDTO.getAmount()))
				.transaction(transactionTransfer)
				.accountNumber(accountFrom.getNumber())
				.build();
		
		// Update new balance in account FROM
		accountFrom.setActualBalance(newBalanceFrom);
		
		// Save transfer
		TransactionTransfer saveTransfer = transferRepository.save(transactionTransfer);

		// Create new balance in account TO
		Balance newBalanceTo = Balance.builder()
				.inicialBalance(actualBalanceTo.getFinalBalance())
				.finalBalance(actualBalanceTo.getFinalBalance().add(transferDTO.getAmount()))
				.transaction(transactionTransfer)
				.accountNumber(accountTo.getNumber())
				.build();

		// Update new balance in account TO
		accountTo.setActualBalance(newBalanceTo);
		accountRepository.save(accountTo);
		
		return new ReceiptDTO(saveTransfer, transferDTO.getAccountNumber(), false);
	}

	private void validateTransferRules(TransferDTO transferDTO, Balance actualBalanceFrom) {
		if (transferDTO.getAccountNumber().equals(transferDTO.getAccountNumberTo())) {
			throw new BusinessException(MessageEnum.ACCOUNT_ORIGIN_DESTINATION_EQUALS);
		}
		if (BigDecimal.ZERO.compareTo(transferDTO.getAmount()) >= 0) {
			throw new BusinessException(MessageEnum.AMOUNT_INVALID);
		}
		if (actualBalanceFrom.getFinalBalance().compareTo(transferDTO.getAmount()) == -1) {
			throw new BusinessException(MessageEnum.AMOUNT_INVALID);
		}
	}

}
