package com.example.demo.application.dto.response

data class QueryPaymentResponse(
    val paymentId: String,
    val type: String) {

    override fun toString(): String {
        return "QueryPaymentResponse(paymentId='$paymentId', type='$type')"
    }
}
