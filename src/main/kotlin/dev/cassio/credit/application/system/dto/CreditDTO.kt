package dev.cassio.credit.application.system.dto

import dev.cassio.credit.application.system.entity.Credit
import dev.cassio.credit.application.system.entity.Customer
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDTO(
    @field:NotNull(message = "creditValue value cannot be null") val creditValue: BigDecimal,
    @field:Future(message = "Invalid dayFirstOfInstallment date") val dayFirstOfInstallment: LocalDate,
    val numberOfInstallment: Int,
    @field:NotNull(message = "customerId value cannot be null") val customerId: Long
) {
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstOfInstallment,
        numberOfInstallments = this.numberOfInstallment,
        customer = Customer(
            id = this.customerId
        )
    )
}
