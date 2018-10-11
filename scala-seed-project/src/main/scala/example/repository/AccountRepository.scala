package example.repository

import java.util.UUID

import example.models.{Account, Customer}

import scala.collection.mutable

class AccountRepository {

  var allAccounts: mutable.Map[String, List[Account]] = mutable.Map.empty

  def create(customer: Customer, newAccount: Account): Account = {
    val customerId = customer.id.getOrElse(throw new IllegalArgumentException("We need a customer with an ID to create an account!"))

    val customerAccounts = allAccounts.getOrElse(customerId, List.empty[Account]) :+ newAccount.copy(id = Option(UUID.randomUUID().toString))
    allAccounts(customer.id.get) = customerAccounts
    newAccount
  }

  def withdrawalFromAccount(accountId: String, amount: Double) = ???
  def depositToAccount(accountId: String, amount: Double) = ???
  //TODO Oppgave, kombiner de to over til en som benytter seg av en lambda feks.
  def updateAccountBalance(accountId: String, updateFunction: Double => Double): Account = ???

  def getAccountsForCustomer(customerId: String): List[Account] = {
    allAccounts.getOrElse(customerId, List.empty[Account])
  }

  def getAccount(id: String): Option[Account] = {
    allAccounts.values.flatten.find(_.id.contains(id))
  }
}
