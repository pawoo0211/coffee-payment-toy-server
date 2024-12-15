package com.example.demo.application.dto.request

data class CreateOrderRequest(
    val orderId: String = "",
    val merchantId: String = "",
    val price: Int = 0) {

    override fun toString(): String {
        return "CreateOrderRequest(orderId='$orderId', merchantId='$merchantId', price=$price)"
    }
}
