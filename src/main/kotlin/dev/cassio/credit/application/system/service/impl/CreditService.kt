package dev.cassio.credit.application.system.service.impl

import dev.cassio.credit.application.system.entity.Credit
import dev.cassio.credit.application.system.repository.CreditRepository
import dev.cassio.credit.application.system.service.ICreditService
import java.lang.RuntimeException
import java.util.*

class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
) : ICreditService {
    override fun save(credit: Credit): Credit {
        credit.apply { customer = customerService.findById(credit.customer?.id!!) }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> = this.creditRepository.findAllByCustomerId(customerId)


    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit:Credit = (this.creditRepository.findByCreditCode(creditCode) ?: throw RuntimeException("CreditCode $creditCode not found"))
        return if (credit.customer?.id == customerId) return credit else throw RuntimeException("Contact admin")
    }
}