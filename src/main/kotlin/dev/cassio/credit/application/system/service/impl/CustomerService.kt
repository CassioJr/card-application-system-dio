package dev.cassio.credit.application.system.service.impl

import dev.cassio.credit.application.system.entity.Customer
import dev.cassio.credit.application.system.exception.BusinessException
import dev.cassio.credit.application.system.repository.CustomerRepository
import dev.cassio.credit.application.system.service.ICustomerService
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class CustomerService(private val customerRepository: CustomerRepository) : ICustomerService {

    override fun save(customer: Customer): Customer {
        return this.customerRepository.save(customer)
    }

    override fun findById(id: Long): Customer = this.customerRepository.findById(id).orElseThrow {
        throw BusinessException("Id $id not found")
    }

    override fun delete(id: Long) {
        val customer: Customer = this.findById(id)
        this.customerRepository.delete(customer)
    }

}