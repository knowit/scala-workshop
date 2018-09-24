package example.models

sealed trait TransactionType { val value : String}

object TransactionType {

  def apply(s: String): TransactionType = {
    s match {
      case "PAYMENT" => PAYMENT
      case _ => throw new RuntimeException("Not a matching value")
    }
  }
}

case object PAYMENT extends TransactionType {val value = "PAYMENT"}
