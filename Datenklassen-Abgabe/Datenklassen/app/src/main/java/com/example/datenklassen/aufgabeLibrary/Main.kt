package com.example.datenklassen.aufgabeLibrary

fun main() {
    val library = Library(mutableListOf())

    library.addBook(Book("The Hobbit", "J.R.R. Tolkien", Genre.FICTION, Available))
    library.addBook(Book("1984", "George Orwell", Genre.FICTION, Available))
    library.addBook(Book("A Brief History of Time", "Stephen Hawking", Genre.SCIENCE, Available))
    library.addBook(Book("Sapiens", "Yuval Noah Harari", Genre.HISTORY, Available))

    val libraryAddress = Library.LibraryAddress("Main Street", "Springfield", "12345")
    libraryAddress.printAddress()

    val member = library.LibraryMember("Bob", "001")

    val bookToCheckout = library.searchBook(title = "The Hobbit", "J.R.R. Tolkien").firstOrNull()
    if (bookToCheckout != null) {
        member.checkoutBook(bookToCheckout, "2024-12-31")
    }
    val bookToReserve = library.searchBook(title = "1984", author = "George Orwell").firstOrNull()
    if (bookToReserve != null) {
        member.reserveBook(bookToReserve)
    }

    library.showBookStatus()

    println("Returning a book:")
    if (bookToCheckout != null) {
        member.returnBook(bookToCheckout)
    }

    library.showBookStatus()
}