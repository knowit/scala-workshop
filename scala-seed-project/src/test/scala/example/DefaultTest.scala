package example

import example.models.Transaction
import example.repository.{AccountRepository, CustomerRepository, TransactionRepository}

object DefaultTest {
  val transactionRepository: TransactionRepository = new TransactionRepository
  val customerRepository: CustomerRepository = new CustomerRepository
  val accountRepository: AccountRepository = new AccountRepository
}
