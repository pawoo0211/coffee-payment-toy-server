package com.example.demo.application

import com.example.demo.application.dto.request.CancelPaymentRequest
import com.example.demo.application.dto.request.CreatePaymentRequest
import com.example.demo.application.dto.request.QueryPaymentRequest
import com.example.demo.application.dto.response.CancelPaymentResponse
import com.example.demo.application.dto.response.CreatePaymentResponse
import com.example.demo.application.dto.response.QueryPaymentResponse
import com.example.demo.domain.Payment
import com.example.demo.domain.PaymentRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PaymentService(private val repository: PaymentRepository) {

    @Transactional
    fun createPayment(request: CreatePaymentRequest): CreatePaymentResponse? {
        val payment = Payment.createPayment(
            request.orderId,
            request.merchantId,
            request.price
        )
        repository.save(payment)
        return CreatePaymentResponse.create(payment)
    }

    @Transactional
    fun cancelPayment(request: CancelPaymentRequest): CancelPaymentResponse? {
        val payment = repository.findByOrderIdAndMerchantId(
            request.orderId,
            request.merchantId
        )?: throw NoSuchElementException(
            "Payment not found for orderId: ${request.orderId} and merchantId: ${request.merchantId}"
        )
        System.out.println("orderId: ${payment.orderId}")
        payment.updateCancel()

        return CancelPaymentResponse.create(payment)
    }

    @Transactional(readOnly = true)
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