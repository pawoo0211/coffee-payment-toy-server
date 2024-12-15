package com.example.demo.application.dto.response

data class CancelPaymentResponse(
    val paymentId: String = "",
    val result: String = "") {

    override fun toString(): String {
        return "CancelPaymentResponse(paymentId='$paymentId', result='$result')"
    }
}
