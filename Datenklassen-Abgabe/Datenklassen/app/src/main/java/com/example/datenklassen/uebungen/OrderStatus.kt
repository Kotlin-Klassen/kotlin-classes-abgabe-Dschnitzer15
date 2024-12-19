package com.example.datenklassen.uebungen

sealed class OrderStatus

data object Pending : OrderStatus()
data class Processing(val estimatedProcessingTime: Int) : OrderStatus()
data class Shipped(val trackingNumber: String, val shippedDate: String) : OrderStatus()
data class Delivered(val deliveryDate: String, val recipient: String) : OrderStatus()
data class Cancelled(val reason: String) : OrderStatus()

fun printOrderStatus(status: OrderStatus) {
    when (status) {
        is Pending -> println("Die Bestellung wurde aufgegeben aber noch nicht bearbeitet")
        is Processing -> println("Bestellung wird bearbeitet. Verbleibende Bearbeitungszeit: ${status.estimatedProcessingTime} Stunden")
        is Shipped -> println("Die Bestellung wurde versendet. Sendungsnummer: ${status.trackingNumber}. Versanddatum: ${status.shippedDate}")
        is Delivered -> println("Die Bestellung wurde zugestellt an ${status.recipient} am ${status.deliveryDate}.")
        is Cancelled -> println("Die Bestellung wurde storniert. Grund: ${status.reason}.")
    }
}

data class OrderS(val orderID: String, var status: OrderStatus) {

    fun updateStatus(newStatus: OrderStatus) {
        status = newStatus
    }

    fun estimateDeliveryTime(): Int {
        return when (status) {
            is Pending -> 5
            is Processing -> 4
            is Shipped -> 3
            is Delivered -> 0
            is Cancelled -> 0
        }
    }
}

fun main() {
    val order = OrderS("ORD123", Pending)
    printOrderStatus(order.status)

    order.updateStatus(Processing(estimatedProcessingTime = 4 ))
    printOrderStatus(order.status)

    order.updateStatus(Shipped(trackingNumber = "TRACK12345", shippedDate = "2024-11-15"))
    printOrderStatus(order.status)

    order.updateStatus(Delivered(deliveryDate = "2024-11-20", recipient = "John Doe"))
    printOrderStatus(order.status)

    println("Voraussichtliche Lieferzeit in Tagen: ${order.estimateDeliveryTime()}")
}