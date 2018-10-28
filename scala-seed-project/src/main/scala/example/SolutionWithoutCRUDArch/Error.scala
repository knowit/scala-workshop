package example.SolutionWithoutCRUDArch

case class InsufficientFunds(message:String) extends Exception(message)
case class AmountMustBePositive(message:String) extends Exception(message)

