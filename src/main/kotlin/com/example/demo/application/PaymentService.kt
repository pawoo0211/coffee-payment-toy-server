package com.example.demo.application

import com.example.demo.application.dto.request.CreatePaymentRequest
import com.example.demo.application.dto.response.CreatePaymentResponse
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
        return CreatePaymentResponse.createPayment(payment)
    }
}