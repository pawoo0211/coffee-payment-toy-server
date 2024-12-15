package com.example.demo.application

import com.example.demo.application.dto.request.CreatePaymentRequest
import com.example.demo.application.dto.request.QueryPaymentRequest
import com.example.demo.application.dto.response.CreatePaymentResponse
import com.example.demo.application.dto.response.QueryPaymentResponse
import com.example.demo.domain.Payment
import com.example.demo.domain.PaymentRepository
import org.springframework.stereotype.Service

@Service
class PaymentService(private val repository: PaymentRepository) {

    fun createPayment(request: CreatePaymentRequest): CreatePaymentResponse? {
        val payment = Payment.createPayment(
            request.orderId,
            request.merchantId,
            request.price
        )

        repository.save(payment)
        return CreatePaymentResponse.create(payment)
    }

    fun queryPayment(request: QueryPaymentRequest): QueryPaymentResponse? {
        val payment = repository.findByOrderIdAndMerchantId(
            request.orderId,
            request.merchantId
        )?: throw NoSuchElementException(
            "Payment not found for orderId: ${request.orderId} and merchantId: ${request.merchantId}"
        )

        return QueryPaymentResponse.create(payment)
    }
}