package workshop

import model.{Account, Customer, Transaction, TransactionType}

/*
Tanken her å lære seg map, flatmap. List collection library i scala, filter etc.
Lære å kobinere funksjoner. Pattern matching kan benytte på flere oppgaver.
I tillegg kan man løse oppgaver med for comprehension. Her kan vi definere oppgavene og gi hints.


*/

class TransactionHistory {
  def sortedByDate(list:List[Transaction]):List[Transaction] = list.sortWith((a, b) => b.timestamp.isBefore(a.timestamp))
  def filterByType(list:List[Transaction], transactionType: TransactionType) = list.filter(t => t.transactionType.value == transactionType.value)
  def filterByTypeAndAmountSortedOnDate(list:List[Transaction],transactionType: TransactionType, amount:Double): List[Transaction] = filterByType(sortedByDate(list), transactionType).filter(x => x.amount > 200) // ny oppgave skriv om til for comprehension
  def filterByFromToAccount(from: Account, to: Account, list:List[Transaction]):List[Transaction] = ???
  def sortTransactionRelatedToCust(cutomer:Customer,list:List[Transaction]): Set[(Customer, List[Transaction])] = ???

  def getLatest(list:List[Transaction]): Option[Transaction] =
    sortedByDate(list).reverse match{
      case h :: tail => Some(h)
      case Nil => None
    }

  def removeOldTransactionByCustomer(customerId:String,set:Set[(Customer, List[Transaction])]): Set[(Customer, List[Transaction])] = {
    set.map(pairValue => (pairValue._1,pairValue._2.dropWhile(t => t.toAccountId == customerId)))

  }

  def removeFirst(list: List[Transaction]): List[Transaction] =  list match {
    case h :: tail => tail
    case _ => Nil
  }

}
