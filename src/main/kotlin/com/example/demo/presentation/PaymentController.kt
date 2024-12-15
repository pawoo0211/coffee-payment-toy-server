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
        System.out.println("결제 생성 요청 : ${request}")
        val createPaymentResponse = paymentService.createPayment(request)
        System.out.println("결제 생성 응답 : ${createPaymentResponse}")
        return createPaymentResponse
    }

    @MutationMapping
    fun cancelPayment(@Argument request: CancelPaymentRequest): CancelPaymentResponse? {
        System.out.println("결제 취소 요청 ${request}")
        val cancelPaymentResponse = paymentService.cancelPayment(request)
        System.out.println("결제 취소 응답 ${cancelPaymentResponse}")
        return cancelPaymentResponse
    }

    @QueryMapping
    fun queryPayment(@Argument request: QueryPaymentRequest): QueryPaymentResponse? {
        System.out.println("결제 조회 요청 ${request}")
        val queryPaymentResponse = paymentService.queryPayment(request)
        System.out.println("결제 조회 응답 ${queryPaymentResponse}")
        return queryPaymentResponse
    }
}