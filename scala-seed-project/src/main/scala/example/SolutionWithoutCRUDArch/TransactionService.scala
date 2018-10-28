package example.SolutionWithoutCRUDArch

import example.SolutionWithoutCRUDArch.model.Transaction
import example.models.Account

import scala.util.Try

/*

Tanken her er å måtte lage objecter. Bruke apply metoder. Lage error håntering og bruke copy.
Samtidig må de dra inn Calculator trait, og bruke noen av funksjonene de laget i calculator

 */

class TransactionServiceImpl {

  def deposit(account: Account, amount:Double): Try[Transaction] = ???
  def withdraw(account: Account, amount:Double): Try[Transaction] = ???
  def transfer(list:List[Transaction]): Try[Transaction] = ???


}