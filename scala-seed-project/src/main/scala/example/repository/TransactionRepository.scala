package example.repository

import example.models.{Account, Transaction}

class TransactionRepository {
  def persist(transaction: Transaction): Transaction = ???
  def retrieve(accountId: String): List[Transaction] = ???
}
