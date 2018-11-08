package example.models

import example.SolutionWithoutCRUDArch.model.AccountType

case class Account(id: Option[String], accountType: AccountType, balance: Double)


