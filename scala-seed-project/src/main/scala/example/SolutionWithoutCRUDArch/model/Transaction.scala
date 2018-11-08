package example.SolutionWithoutCRUDArch.model

import java.time.ZonedDateTime

case class Transaction(fromAccountId: String, toAccountId: Option[String], transactionType: TransactionType, timestamp: ZonedDateTime) extends Ordered[Transaction] {

  override def compare(that: Transaction): Int = ???

}


object Transaction {
  def apply(fromAccountId: String, toAccountId: Option[String], transactionType: TransactionType, timestamp: ZonedDateTime): Transaction = ???
}