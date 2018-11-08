package workshop.model

import java.time.ZonedDateTime

case class Transaction(fromAccountId: String, toAccountId: Option[String], transactionType: TransactionType, timestamp: ZonedDateTime) extends Ordered[Transaction] {

  override def compare(that: Transaction): Int = ???

}


object Transaction {
  def apply(data: String): Transaction = {
    val values = data.split(";")
    val fromAccountId = values(0)
    val toAccountId = Option(values(1))
    val transactionType = TransactionType(values(2))
    val timestamp = ZonedDateTime.parse(values(3))

    Transaction(
      fromAccountId,
      toAccountId,
      transactionType,
      timestamp
    )
  }
}