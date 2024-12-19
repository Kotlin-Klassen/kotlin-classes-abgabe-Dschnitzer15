package com.example.datenklassen.uebungen

data class Product (
    var name: String,
    var category: String,
    var price: Double,
    var inStock: Boolean,
) {
    fun applyDiscount(discount: Double): Product {
        return this.copy(price = price * (discount / 100))
    }
}

data class Order (
    var orderNumber: String,
    var products: List<Product>,
    var customer: String,
) {
    fun orderSum(): Double {
        var sum = 0.0
        for (product in products) {
            sum += product.price
        }
        return sum
    }

    fun filterInStockProducts(): Order {
        val inStockProducts = products.filter { it.inStock }
        return this.copy(products = inStockProducts)
    }
}

fun main() {
    val product1 = Product("Laptop", "Elektronik", 999.99, true)
    val product2 = Product("Kaffeemaschine", "Haushaltsgeräte", 79.99, false)
    val product3 = Product("Smartphone", "Elektronik", 499.99, true)

    val discountedProduct1 = product1.applyDiscount(50.0)
    println("Rabattierter Laptop: $discountedProduct1\n")

    val order = Order("12345", listOf(product1, product2, product3), "Alice")
    println("Gesamtsumme der Bestellung: ${order.orderSum()}\n")

    val inStockOrder = order.filterInStockProducts()
    println("Bestellung mit vorraetigen Produkten: $inStockOrder\n")
}