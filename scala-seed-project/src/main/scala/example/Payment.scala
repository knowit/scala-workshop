package example

import java.util.Date

case class Payment(val dateCreated: Date, val text: String, val event: EventType, val amount: Double,
                   recipient: BankAccount)


