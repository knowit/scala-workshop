package example.SolutionWithoutCRUDArch.model

import example.models.{AccountType, Customer}

case class Account(id: Option[String],accountType: AccountType, balance: Double, owner:Customer)

object Account {
  def apply(): Account = ???
}
