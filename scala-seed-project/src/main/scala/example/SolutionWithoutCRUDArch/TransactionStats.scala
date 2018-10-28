package example.SolutionWithoutCRUDArch

import example.SolutionWithoutCRUDArch.model.Transaction
import example.models.{Account, Customer, TransactionType}


trait TransactionHistory{
  def sortedByDate(list:List[Transaction]):List[Transaction]
  def filterByType(list:List[Transaction], transactionType: TransactionType)
  def filterByTypeAndAmountSortedByDate(list:List[Transaction],transactionType: TransactionType): List[Transaction]
  def sortTransactionRelatedToCust(cutomer:Customer,transaction: List[Transaction]): Set[(Customer, List[Transaction])]
  def filterByFromToAccount(from: Account, to: Account, list:List[Transaction]):List[Transaction]
  def removeOldTransactionByCustomer(customerId:String,set:Set[(Customer, List[Transaction])]): Set[(Customer, List[Transaction])]
  def getLatest(list:List[Transaction]):Option[Transaction]
  def removeFirst(list:List[Transaction]): List[Transaction]
}


class TransactionHistoryImpl extends TransactionHistory {

  def sortedByDate(list:List[Transaction]):List[Transaction] = list.sortWith((a, b) => b.timestamp.isBefore(a.timestamp))
  def filterByType(list:List[Transaction], transactionType: TransactionType) = list.filter(t => t.transactionType.value == transactionType.value)
  def filterByTypeAndAmountSortedByDate(list:List[Transaction],transactionType: TransactionType): List[Transaction] = ???
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

  override def removeFirst(list: List[Transaction]): List[Transaction] =  list match {
    case h :: tail => tail
    case _ => Nil
  }
}
