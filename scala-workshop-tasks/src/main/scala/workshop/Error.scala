package workshop

case class InsufficientFunds(message:String) extends Exception(message)
case class AmountMustBePositive(message:String) extends Exception(message)
case class NoAccoutId(message:String) extends Exception(message)

