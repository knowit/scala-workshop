package example.models

import java.time.LocalDateTime

case class Transaction(transactionType: TransactionType, timestamp: LocalDateTime)

