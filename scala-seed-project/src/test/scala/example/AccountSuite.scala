package example

import example.models._
import example.repository.AccountRepository
import org.scalatest.{Matchers, PropSpec}
import org.scalatest.prop.GeneratorDrivenPropertyChecks
import org.scalacheck.Gen

class AccountSuite extends PropSpec with GeneratorDrivenPropertyChecks with Matchers {
  val repository = new AccountRepository
  val accountTypes = List(CREDIT, DEBIT)
  val validAccountTypes: Gen[AccountType] = Gen.oneOf(accountTypes)
  val validAccountBalances: Gen[Double] = for (n <- Gen.choose[Int](1, 1000)) yield n.toDouble
  val customer = Customer(Some("1"), "henning")

  property("all values for an account should be correctly persisted and retrieved") {
    forAll (validAccountTypes, None, validAccountBalances) { (accountType, accountId, balance) =>
      val account = Account(accountId, accountType, balance)
      val persistedAcc = repository.create(customer, account.accountType, balance)

      persistedAcc.id shouldBe accountId
      persistedAcc.accountType shouldBe accountType
      persistedAcc.balance shouldBe balance
    }
  }
}
