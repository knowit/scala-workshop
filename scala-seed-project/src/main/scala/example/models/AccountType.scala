package example.models

sealed trait AccountType { val value : String}

object AccountType {

  def apply(s: String): AccountType = {
    s match {
      case "CREDIT" => CREDIT
      case "DEBIT" => DEBIT
      case _ => throw new RuntimeException("Not a matching value")
    }
  }
}

case object CREDIT extends AccountType {val value = "CREDIT"}
case object DEBIT extends AccountType {val value = "DEBIT"}
