package workshop

import java.time.ZonedDateTime

import workshop.model._

object TestData {


  val henry = Customer(Some("1"), "Henry")
  val magnar = Customer(Some("1"), "Magnar")
  val marit = Customer(Some("1"), "Marit")


  val accountHenry = Account(Some("1"), DEBIT, 100, henry)
  val accountMagnar = Account(Some("2"), DEBIT, 100, magnar)
  val accountMarit = Account(Some("3"), DEBIT, 100, marit)

  val transactionPaymentCustHenry = Transaction("1",Some("2"),PAYMENT, ZonedDateTime.now(), 300)
  val transactionPaymentCustMagnar = Transaction("2",Some("3"),PAYMENT, ZonedDateTime.now(), 200)
  val transactionPaymentCustMarit =  Transaction("3",Some("1"),PAYMENT, ZonedDateTime.now(), 200)


  val transactionWithdrawCustHenry = Transaction("1",None,WITHDRAW, ZonedDateTime.now(), 200)
  val transactionWithdrawCustMagnar = Transaction("2",None,WITHDRAW, ZonedDateTime.now(), 100)
  val transactionWithdrawCustMarit =  Transaction("3",None,WITHDRAW, ZonedDateTime.now(), 300)


  val transactionDepositCustHenry = Transaction("1",None, DEPOSIT,ZonedDateTime.now(), 500)
  val transactionDepositCustMAgnar = Transaction("2",None,DEPOSIT, ZonedDateTime.now(), 50)
  val transactionDepositCustMarit =  Transaction("3",None,DEPOSIT, ZonedDateTime.now(), 50)


  def transactionList = List(
    transactionPaymentCustHenry,
    transactionPaymentCustMagnar,
    transactionPaymentCustMarit,
    transactionWithdrawCustHenry,
    transactionWithdrawCustMagnar,
    transactionWithdrawCustMarit,
    transactionDepositCustHenry,
    transactionDepositCustMAgnar,
    transactionDepositCustMarit




  )
}
