package com.example.demo.application.dto.response

data class CreateOrderResponse(
    val paymentId: String = "",
    val result: String = "") {

    override fun toString(): String {
        return "CreateOrderResponse(paymentId='$paymentId', type='$result')"
    }
}