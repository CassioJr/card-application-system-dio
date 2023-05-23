package dev.cassio.credit.application.system.dto

import dev.cassio.credit.application.system.entity.Customer
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class CustomerUpdateDto(
    @field:NotEmpty(message = "Invalid firstName input") val firstName: String,
    @field:NotEmpty(message = "Invalid lastName input") val lastName: String,
    @field:NotNull(message = "Invalid income input") val income: BigDecimal,
    @field:NotEmpty(message = "Invalid zipcode input") val zipcode: String,
    @field:NotEmpty(message = "Invalid street input") val street: String
) {
    fun toEntity(customer: Customer): Customer {
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.zipcode = this.zipcode
        customer.address.street = this.street
        return customer
    }
}
