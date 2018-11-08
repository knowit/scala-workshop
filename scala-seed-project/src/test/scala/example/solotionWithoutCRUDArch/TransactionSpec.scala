package example.solotionWithoutCRUDArch

import example.SolutionWithoutCRUDArch.TransactionHistory
import org.scalatest.{Matchers, WordSpec}

class TransactionSpec  extends WordSpec with Matchers{
val transactions = TestData.transactionList
val transactionHistory = new TransactionHistory()

  "removeFirst in list" should {
    "be 8" in {
      transactionHistory.removeFirst(transactions) === 6
    }
  }

}


