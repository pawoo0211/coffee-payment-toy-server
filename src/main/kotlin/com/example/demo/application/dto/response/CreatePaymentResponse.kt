package com.example.demo.application.dto.response

import com.example.demo.domain.Payment

data class CreatePaymentResponse(
    val paymentId: Long = 0L,
    val result: String = "") {

    override fun toString(): String {
        return "CreatePaymentResponse(paymentId='$paymentId', result='$result')"
    }

    companion object {
        fun create(payment: Payment): CreatePaymentResponse? {
            return CreatePaymentResponse(paymentId = payment.id, "SUCCESS")
        }
    }
}