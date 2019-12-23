package com.example.marvelcomics

class Person {
    var name: String = ""
    var lastName = ""

    val age: Int = 30

    fun greet(): String {
        return "hi"
    }

    fun sayGoodbye() = "bye"

//    fun sayGoodbye(): String {
//        return "Bye"
//    }

    fun jump() {
        println("")
    }
}

class Car(var brand: String) {
    var year: Int = 0
}
