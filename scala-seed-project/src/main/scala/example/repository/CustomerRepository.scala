package example.repository

import example.models.Customer

trait CustomerRepository {
  def create(name: String): Customer
  def get(id: String): Option[Customer]
}
