package example.service

import java.time.LocalDateTime

import example.models.{Account, Transaction, TransactionType}
import example.repository.TransactionRepository

class TransactionService(repository: TransactionRepository) {
  //TODO Oppgaver
  //Kan utvides med Settings
  //Feilhåndtering ved overtrekk
  //Feilhåndtering hvor accounts ikke eksisterer

  def transfer(from: Account, to: Account, amount: Double): Transaction = ???
  def withdraw(from: Account, amount: Double): Transaction = ???
  def deposit(to: Account, amount: Double): Transaction = ???
  def history(account: Account, from: Option[LocalDateTime], to: Option[LocalDateTime]): List[Transaction] = ???
}
