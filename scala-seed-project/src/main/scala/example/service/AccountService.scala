package example.service

import example.models.{Account, AccountType, Customer}
import example.repository.AccountRepository

class AccountService(accountRepository: AccountRepository) {

  def create(customer: Customer, accountType: AccountType, balance: Double): Account = {
    val newAccount = Account(None, accountType, balance)
    accountRepository.create(customer, newAccount)
  }

  def updateAccountBalance(accountId: String): Unit = {
    accountRepository.updateAccountBalance(accountId, (balance: Double) => balance - 50)
  }

  def getAccountsForCustomer(customerId: String): List[Account] = {
    accountRepository.getAccountsForCustomer(customerId)
  }

  def get(id: String): Option[Account] = {
    accountRepository.getAccount(id)
  }

}
