package example.repository

import example.models.{Account, Transaction}

trait TransactionRepository {
  def persist(transaction: Transaction): Transaction
  def retrieve(accountId: String): List[Transaction]
}
