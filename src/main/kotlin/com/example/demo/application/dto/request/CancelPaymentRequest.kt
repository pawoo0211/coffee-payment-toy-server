package com.example.demo.application.dto.request

data class CancelPaymentRequest(
    val orderId: String = "",
    val merchantId: String = "") {

    override fun toString(): String {
        return "CancelPaymentRequest(orderId='$orderId', merchantId='$merchantId')"
    }
}
