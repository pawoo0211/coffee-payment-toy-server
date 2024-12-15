package com.example.demo.presentation

import com.example.demo.application.dto.request.CancelOrderRequest
import com.example.demo.application.dto.request.CreateOrderRequest
import com.example.demo.application.dto.request.QueryOrderRequest
import com.example.demo.application.dto.response.CancelOrderResponse
import com.example.demo.application.dto.response.CreateOrderResponse
import com.example.demo.application.dto.response.QueryOrderResponse
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PaymentController {

    @QueryMapping
    fun hello(): String {
        return "Hello, GraphQL!"
    }

    @MutationMapping
    fun createOrder(@Argument request: CreateOrderRequest): CreateOrderResponse {
        return CreateOrderResponse(
            paymentId = "PAY1234",
            result = "SUCCESS"
        )
    }

    @MutationMapping
    fun cancelOrder(@Argument request: CancelOrderRequest): CancelOrderResponse {
        return CancelOrderResponse(
            paymentId = "temp_id",
            result = "CANCELED"
        )
    }

    @QueryMapping
    fun findOrder(@Argument request: QueryOrderRequest): QueryOrderResponse {
        return QueryOrderResponse(
            "temp_id",
            "temp_type"
        )
    }
}