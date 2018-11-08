package example

import java.time.{LocalDateTime, ZoneOffset}

import example.SolutionWithoutCRUDArch.model.{Customer, PAYMENT, TransactionType}
import example.models._
import example.repository.TransactionRepository
import org.scalacheck.Gen
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalatest.{Matchers, PropSpec}

class TransactionSuite extends PropSpec with GeneratorDrivenPropertyChecks with Matchers {
  val repository = new TransactionRepository
  val transactionTypes: List[TransactionType] = List(PAYMENT)
  val validTransactionTypes: Gen[TransactionType] = Gen.oneOf(transactionTypes)
  val validFromAccountIds: Gen[String] = Gen.identifier
  val validToAccountIds: Gen[String] = Gen.identifier
  val validTimestamps: Gen[LocalDateTime] = Gen.chooseNum(10000, 50000).map(num => LocalDateTime.ofEpochSecond(num.toLong, 0, ZoneOffset.UTC))
  val customer = Customer(Some("1"), "henning")

  property("all values for a transaction should be correctly persisted and retrieved") {
    forAll (validFromAccountIds, validToAccountIds, validTransactionTypes, validTimestamps) {
      (fromAccountId, toAccountId, transactionType, timestamp) =>
        val transaction = Transaction(fromAccountId, toAccountId, transactionType, timestamp)
        val persistedTransaction = repository.persist(transaction)

        persistedTransaction.fromAccountId shouldBe fromAccountId
        persistedTransaction.toAccountId shouldBe toAccountId
        persistedTransaction.transactionType shouldBe transactionType
        persistedTransaction.timestamp shouldBe timestamp
    }
  }

  // TODO
  property("amount of transactions should increase every time we add a transaction") {
    true shouldBe true
  }

  // TODO
  property("retrieveWithFilter should return the same as using filter with the same condition on all of the transaction") {
    true shouldBe true
  }
}
