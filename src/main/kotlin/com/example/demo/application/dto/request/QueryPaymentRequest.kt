package com.example.demo.application.dto.request

data class QueryPaymentRequest(
    val orderId: String = "",
    val merchantId: String = "") {

    override fun toString(): String {
        return "QueryPaymentRequest(orderId='$orderId', merchantId='$merchantId')"
    }
}
