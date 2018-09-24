package example.repository

import example.models.{Account, AccountType, Customer}

trait AccountRepository {
  def create(customer: Customer, accountType: AccountType): Account
  def get(id: String): Option[Account]
}
