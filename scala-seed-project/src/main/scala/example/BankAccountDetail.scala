package example

class BankAccountDetail(account: BankAccount, event: BankEvent) {

  var  detail: List[BankEvent] = List(event) // todo loose the var
  var bankAccount: BankAccount = account // todo loose the var

  def sizeDetail() : Int = {
    return detail.size
  }

  def removeEventType(eventType: EventType) = {
    detail = detail.filter(_.event != eventType )
  }

  def addEvent(e: BankEvent) {
    detail = e :: detail
  }

  def getBalance() : Double = {
    val balanceAmount = detail.map(_.amount)
    return balanceAmount.reduceLeft(_ + _)
  }


}
