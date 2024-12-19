package com.example.datenklassen.uebungen

class Library(val libraryName: String) {

    class Book(private val title: String, private val author: String) {
        fun getInfo() = "Book: $title, Author: $author"
    }

    inner class Librarian(private val librarianName: String) {
        fun getSentence() = "I am $librarianName and my library is named $libraryName"
    }
}

fun main() {
    val book = Library.Book("Book21", "Bob")
    println(book.getInfo())

    val myLibrary = Library("Library3")
    val librarian = myLibrary.Librarian("Grog")
    println(librarian.getSentence())
}