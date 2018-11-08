package example.models

import java.time.LocalDateTime

import example.SolutionWithoutCRUDArch.model.TransactionType

case class Transaction(fromAccountId: String, toAccountId: String, transactionType: TransactionType, timestamp: LocalDateTime)

