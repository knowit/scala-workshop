package example.models

//TODO Oppgave

sealed trait Setting { val data: String }

case class FavoriteAccount(data: String) extends Setting
case class StandardWithdrawalAccount(data: String) extends Setting
case class StandardDepositAccount(data: String) extends Setting
