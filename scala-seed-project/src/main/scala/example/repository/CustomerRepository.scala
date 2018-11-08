package example.repository

import example.SolutionWithoutCRUDArch.model.Customer

class CustomerRepository {
  def create(name: String): Customer = ???
  def get(id: String): Option[Customer] = ???
}
