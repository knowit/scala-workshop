package example.SolutionWithoutCRUDArch

import java.time.ZonedDateTime

import example.SolutionWithoutCRUDArch.model.Transaction
import example.models.{Account, DEPOSIT, TransactionType}

import scala.util.{Failure, Success, Try}

trait TransactionService{
  def deposit(account: Account, amount:Double): Try[Transaction]
  def withdraw(account: Account, amount:Double): Try[Transaction]
  def transfer(list:List[Transaction]): Try[Transaction]

}


class TransactionServiceImpl extends TransactionService with Calculator {

  def deposit(account: Account, amount:Double): Try[Transaction] = {

    if (amount > 0) {
      val b = account.balance
      val newAmount = sum(b,amount)
      val newAccount = account.copy(balance = newAmount)
      Success(Transaction(newAccount.id.get, None, DEPOSIT, ZonedDateTime.now())) // todo make more functional
    }else{
      Failure(AmountMustBePositive("Amount must be greater than 0"))
    }
  }

  // Todo test that this does not overdraw account
  def withdraw(account: Account, amount:Double): Try[Transaction] = {
    if (0 < amount && amount <= account.balance) {
      val b = account.balance()
      val newAmount = minus(b,amount)
      val newAccount = account.copy(balance = newAmount)
      Success(Transaction(newAccount.id.get, None, DEPOSIT, ZonedDateTime.now())) // todo make more functional
    } else Failure(InsufficientFunds("Insufficient funds"))
  }

  def transfer(list:List[Transaction]): Try[Transaction] = ???


}
object TransactionObject {
  def apply(fromAccountId: String, toAccountId: Option[String], transactionType: TransactionType, timestamp: ZonedDateTime) =
    Transaction(fromAccountId,toAccountId,transactionType,timestamp)

}