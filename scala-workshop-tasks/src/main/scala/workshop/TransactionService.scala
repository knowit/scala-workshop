package workshop

import java.time.ZonedDateTime

import workshop.model._

import scala.util.{Failure, Success, Try}

/*

Tanken her er å måtte lage objecter. Bruke apply metoder. Lage error håntering og bruke copy.
Samtidig må de dra inn Calculator trait, og bruke noen av funksjonene de laget i calculator

 */

class TransactionServiceImpl extends Calculator {

  def deposit(account: Account, amount:Double): Try[Transaction] = {

    if (amount > 0) {
      val b = account.balance
      val newAmount = sum(b,amount)
      val newAccount = account.copy(balance = newAmount)
      newAccount.id.map{ id =>
        Success(Transaction(id, None, DEPOSIT, ZonedDateTime.now(), amount))
      }.getOrElse(Failure(NoAccoutId("Missing accountId")))
    }else{
      Failure(AmountMustBePositive("Amount must be greater than 0"))
    }
  }

  // Todo test that this does not overdraw account
  def withdraw(account: Account, amount:Double): Try[Transaction] = {
    if (0 < amount && amount <= account.balance) {
      val b = account.balance
      val newAmount = minus(b,amount)
      val newAccount = account.copy(balance = newAmount)
      newAccount.id.map{ id =>
        Success(Transaction(id, None, WITHDRAW, ZonedDateTime.now(), amount))
      }.getOrElse(Failure(NoAccoutId("Missing accountId")))
    } else Failure(InsufficientFunds("Insufficient funds"))
  }

  def transfer(list:List[Transaction]): Try[Transaction] = ???


}
object TransactionObject {
  def apply(fromAccountId: String, toAccountId: Option[String], transactionType: TransactionType, timestamp: ZonedDateTime, amount:Double) =
    Transaction(fromAccountId,toAccountId,transactionType,timestamp, amount)

}