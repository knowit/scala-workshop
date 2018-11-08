package example.SolutionWithoutCRUDArch

import example.SolutionWithoutCRUDArch.model.{Customer, Transaction, TransactionType}
import example.models.Account

/*
Tanken her å lære seg map, flatmap. List collection library i scala, filter etc.
Lære å kobinere funksjoner. Pattern matching kan benytte på flere oppgaver.
I tillegg kan man løse oppgaver med for comprehension. Her kan vi definere oppgavene og gi hints.


*/

class TransactionHistory {

  def sortedByDate(list:List[Transaction]):List[Transaction] = ???
  def filterByType(list:List[Transaction], transactionType: TransactionType) = ???
  def filterByTypeAndAmountSortedByDate(list:List[Transaction],transactionType: TransactionType): List[Transaction] = ???
  def filterByFromToAccount(from: Account, to: Account, list:List[Transaction]):List[Transaction] = ???
  def sortTransactionRelatedToCust(cutomer:Customer,list:List[Transaction]): Set[(Customer, List[Transaction])] = ???
  def getLatest(list:List[Transaction]): Option[Transaction] = ???
  def removeOldTransactionByCustomer(customerId:String,set:Set[(Customer, List[Transaction])]): Set[(Customer, List[Transaction])] = ???
  def removeFirst(list: List[Transaction]): List[Transaction] =  ???
}
