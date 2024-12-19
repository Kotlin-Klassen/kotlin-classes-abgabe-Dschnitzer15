package com.example.datenklassen.aufgabeLibrary

sealed class BookStatus

data object Available: BookStatus()
data class CheckedOut(val dueDate: String): BookStatus()
data class Reserved(val reservedBy: String): BookStatus()

fun printBookStatus(status: BookStatus) {
    when (status) {
        is Available -> println("The book is available.")
        is CheckedOut -> println("The book is checked out. Return date: ${status.dueDate}")
        is Reserved -> println("The book is reserved by: ${status.reservedBy}")
    }
}
