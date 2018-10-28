package example.SolutionWithoutCRUDArch.model

import java.time.ZonedDateTime

import example.models.TransactionType

case class Transaction(fromAccountId: String, toAccountId: Option[String], transactionType: TransactionType, timestamp: ZonedDateTime) extends Ordered[Transaction] {

  override def compare(that: Transaction): Int = ???
}
