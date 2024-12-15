package com.example.demo.presentation

import com.example.demo.application.PaymentService
import com.example.demo.application.dto.request.CancelPaymentRequest
import com.example.demo.application.dto.request.CreatePaymentRequest
import com.example.demo.application.dto.request.QueryPaymentRequest
import com.example.demo.application.dto.response.CancelPaymentResponse
import com.example.demo.application.dto.response.CreatePaymentResponse
import com.example.demo.application.dto.response.QueryPaymentResponse
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PaymentController(private val paymentService: PaymentService) {

    @QueryMapping
    fun hello(): String {
        return "Hello, GraphQL!"
    }

    @MutationMapping
    fun createPayment(@Argument request: CreatePaymentRequest): CreatePaymentResponse? {
        val createPaymentResponse = paymentService.createPayment(request)
        return createPaymentResponse
    }

    @MutationMapping
    fun cancelOrder(@Argument request: CancelPaymentRequest): CancelPaymentResponse {
        return CancelPaymentResponse(
            paymentId = "temp_id",
            result = "CANCELED"
        )
    }

    @QueryMapping
    fun findOrder(@Argument request: QueryPaymentRequest): QueryPaymentResponse {
        return QueryPaymentResponse(
            "temp_id",
            "temp_type"
        )
    }
}