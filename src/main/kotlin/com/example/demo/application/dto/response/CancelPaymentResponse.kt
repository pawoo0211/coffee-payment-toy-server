package com.example.demo.application.dto.response

import com.example.demo.domain.Payment

data class CancelPaymentResponse(
    val orderId: String = "",
    val result: String = "") {

    companion object {
        fun create(payment: Payment): CancelPaymentResponse? {
            return CancelPaymentResponse(payment.orderId, "SUCCESS")
        }
    }

    override fun toString(): String {
        return "CancelPaymentResponse(orderId='$orderId', result='$result')"
    }
}
