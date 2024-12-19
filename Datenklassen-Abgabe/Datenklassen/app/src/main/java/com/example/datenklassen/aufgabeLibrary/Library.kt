package com.example.datenklassen.aufgabeLibrary

class Library(private var bookList: MutableList<Book>) {

    class LibraryAddress(private val street: String, private val city: String, private val zipCode: String) {
        fun printAddress() {
            println("Street: $street, City: $city, ZipCode: $zipCode")
        }
    }

    inner class LibraryMember(private val memberName: String, private val memberID: String) {

        fun checkoutBook(book: Book, dueDate: String) {
            when(book.status) {
                is Available -> {
                    book.status = CheckedOut(dueDate)
                    println("$memberName checked out '${book.title}'. Due date: $dueDate.")
                }
                is CheckedOut -> println("The book '${book.title}' is already checked out.")
                is Reserved -> println("The book '${book.title}' is reserved and cannot be checked out.")
            }
        }

        fun reserveBook(book: Book) {
            when (book.status) {
                is Available -> {
                    book.status = Reserved(memberName)
                    println("$memberName reserved '${book.title}'.")
                }
                is CheckedOut -> println("The book '${book.title}' is checked out and cannot be reserved.")
                is Reserved -> println("The book '${book.title}' is already reserved by someone else.")
            }
        }

        fun returnBook(book: Book) {
            when (book.status) {
                is Available -> println("The book '${book.title}' is already available.")
                is CheckedOut -> {
                    book.status = Available
                    println("The book '${book.title}' has been returned and is now available.")
                }
                is Reserved -> println("The book '${book.title}' is reserved. Please cancel the reservation before returning.")
            }
        }
    }

    fun addBook(book: Book) {
        bookList.add(book)
        println("Added '${book.title}' by ${book.author} to the library.")
    }

    fun searchBook(title: String, author: String): List<Book> {
        return bookList.filter {
            (it.title.contains(title, ignoreCase = true)) && (it.author.contains(author, ignoreCase = true))
        }
    }

    fun showBookStatus() {
        println("Current status of books in the library: ")
        bookList.forEach { book ->
            print("${book.title}: ")
            printBookStatus(book.status)
        }
    }
}