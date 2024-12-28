package com.example.demo.domain

import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.UUID

@Entity
@Table(name = "payments")
class Payment(
    @Id
    val id: String = "",

    @Column(name = "order_id", nullable = false, unique = true)
    var orderId: String = "",

    @Column(name = "merchant_id", nullable = false)
    var merchantId: String = "",

    @Column(name = "price", nullable = false)
    var price: Int = 0,

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    var status: PaymentStatus = PaymentStatus.PENDING,

    @Column(name = "created_at", nullable = false, updatable = false)
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(name = "updated_at", nullable = false)
    var updatedAt: LocalDateTime = LocalDateTime.now()
) {
    fun updateCancel() {
        this.status = PaymentStatus.CANCELLED
        this.updatedAt = LocalDateTime.now()
    }

    companion object {
        fun createPayment(orderId: String, merchantId: String, price: Int): Payment {
            return Payment(
                id = "PG_" + UUID.randomUUID().toString().substring(0, 8),
                orderId = orderId,
                merchantId = merchantId,
                price = price,
                status = PaymentStatus.PAID
            )
        }
    }
}