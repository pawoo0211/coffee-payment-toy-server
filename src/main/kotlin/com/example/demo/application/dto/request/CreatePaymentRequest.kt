package com.example.demo.application.dto.request

data class CreatePaymentRequest(
    val orderId: String = "",
    val merchantId: String = "",
    val price: Int = 0) {

    override fun toString(): String {
        return "CreatePaymentRequest(orderId='$orderId', merchantId='$merchantId', price=$price)"
    }
}
