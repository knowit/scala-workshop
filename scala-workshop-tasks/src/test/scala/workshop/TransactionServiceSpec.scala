package workshop

import org.scalatest.{Matchers, WordSpec}

class TransactionServiceSpec  extends WordSpec with Matchers{
  val transactions = TestData.transactionList
  val transactionService = new TransactionServiceImpl()

  "Deposit" should {
    "return a valid transaction" in {
      val account = TestData.accountHenry
      val depositAmount = 50
      val transaction = transactionService.deposit(account, depositAmount)

      assert(transaction.isSuccess)
      assert(transaction.get.amount === depositAmount)
    }
  }

  "Deposit" should {
    "throw AmountMustBePositiveException when amount < 1" in {
      val account = TestData.accountHenry
      val depositAmount = -5
      val failedTransaction = transactionService.deposit(account, depositAmount)

      assert(failedTransaction.isFailure)
    }
  }

}


