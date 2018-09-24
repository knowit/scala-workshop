package example

import java.util.Date

case class BankEvent(created: Date, message: String, event: EventType, amount: Double)


