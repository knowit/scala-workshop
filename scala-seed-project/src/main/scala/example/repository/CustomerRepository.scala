package example.repository

import example.models.Customer

class CustomerRepository {
  def create(name: String): Customer = ???
  def get(id: String): Option[Customer] = ???
}
