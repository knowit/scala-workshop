package example.models

case class Account(id: Option[String], accountType: AccountType, balance: Double)

object Account {
  def apply() = ???
  def getAccountByType(list:List[Account], accountType:AccountType) = list.filter(_.accountType.value == accountType.value)
}