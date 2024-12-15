package com.example.demo.application.dto.response

data class CancelOrderResponse(
    val paymentId: String = "",
    val result: String = "") {

    override fun toString(): String {
        return "CancelOrderResponse(paymentId='$paymentId', result='$result')"
    }
}
