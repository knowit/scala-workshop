package example.repository

import example.models.Transaction

class TransactionRepository {
  var transactions: List[Transaction] = Nil

  def persist(transaction: Transaction): Transaction = {
    transactions = transaction :: transactions
    transaction
  }

  def retrieveFrom(accountId: String): List[Transaction] = {
    transactions.filter(_.fromAccountId == accountId)
  }

  def retrieveTo(accountId: String): List[Transaction] = {
    transactions.filter(_.toAccountId == accountId)
  }

  def retrieveWithFilter(condition: Transaction => Boolean): List[Transaction] = {
    transactions.filter(condition)
  }
}
