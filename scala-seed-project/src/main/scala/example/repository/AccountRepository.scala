package example.repository

import java.util.UUID

import example.models.{Account, AccountType, Customer}

class AccountRepository {

  var allAccounts: Map[String, List[Account]] = Map.empty

  def create(customer: Customer, accountType: AccountType, balance: Double): Account = {
    val customerId = customer.id.getOrElse(throw new IllegalArgumentException("We need a customer with an ID to create an account!"))

    val newAccount = Account(Option(UUID.randomUUID().toString), accountType, balance)
    val customerAccounts = allAccounts.getOrElse(customerId, List.empty[Account]) :+ newAccount
    allAccounts(customer.id.get) = customerAccounts
    newAccount
  }

  def getAccountsForCustomer(customerId: String): List[Account] = {
    allAccounts.getOrElse(customerId, List.empty[Account])
  }

  def get(id: String): Option[Account] = {
    allAccounts.values.flatten.find(_.id.contains(id))
  }
}
