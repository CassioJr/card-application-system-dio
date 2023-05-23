package dev.cassio.credit.application.system.dto

import dev.cassio.credit.application.system.entity.Address
import dev.cassio.credit.application.system.entity.Customer
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDTO(
    @field:NotEmpty(message = "Invalid firstName input") val firstName: String,
    @field:NotEmpty(message = "Invalid lastName input") val lastName: String,
    @field:CPF(message = "Invalid cpf input") val cpf: String,
    @field:NotNull(message = "Invalid income input") val income: BigDecimal,
    @field:Email(message = "Invalid email")
    @field:NotEmpty(message = "Invalid email input")val email: String,
    @field:NotEmpty(message = "Invalid password input") val password: String,
    @field:NotEmpty(message = "Invalid zipcode input") val zipcode: String,
    @field:NotEmpty(message = "Invalid street input") val street: String
) {
    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(
            zipcode = this.zipcode,
            street = this.street
        )
    )
}
