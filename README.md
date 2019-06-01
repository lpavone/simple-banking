# SimpleBanking
Software Developer technical test - wordnettps.com

# Instructions
It should be a web application and should have a REST endpoint for each of these services:
1. Create account(s) - a user can create an account, associate a name with it, give it a unique account number, add a starting balance, etc.
2. Make deposit - a user can lodge an amount into an account (balance increase)
3. Make transfer - a user can transfer an amount from one account to another (balance transfer)
4. View transactions - a user can view recent, or all, transactions for an account (statement)

###Entities:
* **Account** (name, address, phone number, balance)
* **Transaction** (date, transaction type, amount, account from, account to)
_(feel free to expand on these - they are meant as a starting point)_

We are interested to see a clear design, clean code, code integrity and safety in a multi-thread environment, etc.
It is not necessary to implement a full data access layer - objects can be stored in-memory and exist for the lifetime of the app - but a clean separation of business services from data access would be nice to see.

Ideally the project should be buildable through maven and you can use any framework you want for it.

Send a url to a github / bitbucket / private git repository containing your work.