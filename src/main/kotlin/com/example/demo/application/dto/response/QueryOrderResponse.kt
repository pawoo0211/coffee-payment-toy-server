package com.example.demo.application.dto.response

data class QueryOrderResponse(
    val paymentId: String,
    val type: String) {

    override fun toString(): String {
        return "QueryOrderResponse(paymentId='$paymentId', type='$type')"
    }

}
