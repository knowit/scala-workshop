package example

sealed trait EventType { val value : String}

object EventType {

  final val values = "DRAFT, PROPOSED, VERSIONED, DEPRECATED"



  def apply(s: String): EventType = {
    s match {
      case "PAYMENT" => PAYMENT
      case _ => throw new RuntimeException("Not a matching value")
    }
  }
}

case object PAYMENT extends EventType {val value = "PAYMENT"}
