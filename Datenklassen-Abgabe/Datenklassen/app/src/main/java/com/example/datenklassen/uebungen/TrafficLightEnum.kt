package com.example.datenklassen.uebungen

enum class TrafficLight(private val description: String) {
    RED("Stop"),
    YELLOW("Wait"),
    GREEN("Go");

fun printDescription() {
    println(description)
    }
}

fun handleTrafficLight(trafficLight: TrafficLight) {
    when (trafficLight) {
        TrafficLight.RED -> println("Stop or something bad will happen!")
        TrafficLight.YELLOW -> println("Just a few more seconds...")
        TrafficLight.GREEN -> println("You may go now.")
    }
}

fun main() {
    val currentLight = TrafficLight.RED
    currentLight.printDescription()
    handleTrafficLight(currentLight)
}