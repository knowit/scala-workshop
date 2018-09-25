package example.models

import java.time.LocalDateTime

case class Transaction(fromAccountId: String, toAccountId: String, transactionType: TransactionType, timestamp: LocalDateTime)

