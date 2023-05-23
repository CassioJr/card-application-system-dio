package dev.cassio.credit.application.system.dto

import dev.cassio.credit.application.system.entity.Credit
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID

data class CreditViewList(
    val creditCode: UUID,
    val creditValue: BigDecimal,
    val dayFirstOfInstallment: LocalDate,
    val numberOfInstallment: Int
) {
    constructor(credit: Credit): this(
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        dayFirstOfInstallment = credit.dayFirstInstallment,
        numberOfInstallment = credit.numberOfInstallments
    )
}
