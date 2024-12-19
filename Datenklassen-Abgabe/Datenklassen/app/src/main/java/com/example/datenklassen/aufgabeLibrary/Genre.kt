package com.example.datenklassen.aufgabeLibrary

enum class Genre(private val description: String) {
    FICTION("Fictional stories and novels"),
    NON_FICTION("Books based on factual information and real events"),
    SCIENCE("Works focused on scientific concepts, research, and discoveries"),
    HISTORY("Books detailing historical events and periods"),
    CHILDREN("Literature specifically written for young readers");

    fun printDescription() {
        println(description)
    }
}