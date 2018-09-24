package example.repository

import example.models.{Account, AccountType, Customer}

class AccountRepository {
  def create(customer: Customer, accountType: AccountType, balance: Double): Account = Account(None, accountType, balance)
  def get(id: String): Option[Account] = ???
}
