package com.example.demo.application.dto.request

data class QueryOrderRequest(
    val orderId: String = "",
    val merchantId: String = "") {

    override fun toString(): String {
        return "QueryOrderRequest(orderId='$orderId', merchantId='$merchantId')"
    }
}
