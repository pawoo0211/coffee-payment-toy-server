package com.example.demo.application.dto.request

data class CancelOrderRequest(val orderId: String = "") {

    override fun toString(): String {
        return "CancelOrderRequest(orderId='$orderId')"
    }
}
