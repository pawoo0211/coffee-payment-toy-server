package com.example.demo.domain

import org.springframework.data.jpa.repository.JpaRepository

interface PaymentRepository: JpaRepository<Payment, Long> {
    fun findByOrderIdAndMerchantId(orderId: String, merchantId: String): Payment?
}