package example.SolutionWithoutCRUDArch.model

case class Account(id: Option[String],accountType: AccountType, balance: Double, owner:Customer)

object Account {
  def apply(): Account = ???
}
