package com.example.demo.application.dto.response

import com.example.demo.domain.Payment

data class QueryPaymentResponse(
    val paymentId: String,
    val type: String) {

    companion object {
        fun create(payment: Payment): QueryPaymentResponse {
            return QueryPaymentResponse(payment.orderId, payment.status.toString())
        }
    }

    override fun toString(): String {
        return "QueryPaymentResponse(paymentId='$paymentId', type='$type')"
    }
}
