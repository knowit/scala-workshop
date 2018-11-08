package workshop

import java.time.ZonedDateTime

import workshop.model._

object TestData {


  val tale = Customer(Some("1"), "Tale")
  val henning = Customer(Some("1"), "Henning")
  val anita = Customer(Some("1"), "Anita")


  val accountTale = Account(Some("1"), DEBIT, 100, tale)
  val accountHenning = Account(Some("2"), DEBIT, 100, henning)
  val accountAnita = Account(Some("2"), DEBIT, 100, anita)

  val transactionPaymentCustTale = Transaction("1",Some("2"),PAYMENT, ZonedDateTime.now())
  val transactionPaymentCustHenning = Transaction("2",Some("3"),PAYMENT, ZonedDateTime.now())
  val transactionPaymentCustAnita =  Transaction("3",Some("1"),PAYMENT, ZonedDateTime.now())


  val transactionWithdrawCustTale = Transaction("1",None,WITHDRAW, ZonedDateTime.now())
  val transactionWithdrawCustHenning = Transaction("2",None,WITHDRAW, ZonedDateTime.now())
  val transactionWithdrawCustAnita =  Transaction("3",None,WITHDRAW, ZonedDateTime.now())


  val transactionDepositCustTale = Transaction("1",None, DEPOSIT,ZonedDateTime.now())
  val transactionDepositCustHenning = Transaction("2",None,DEPOSIT, ZonedDateTime.now())
  val transactionDepositCustAnita =  Transaction("3",None,DEPOSIT, ZonedDateTime.now())


  def transactionList = List(
    transactionPaymentCustTale,
      transactionPaymentCustHenning,
    transactionPaymentCustAnita,
    transactionWithdrawCustTale,
    transactionWithdrawCustHenning,
    transactionWithdrawCustAnita,
    transactionDepositCustTale,
    transactionDepositCustHenning,
    transactionDepositCustHenning




  )
}
