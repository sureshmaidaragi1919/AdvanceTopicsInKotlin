package com.example.advancetopicsinkotlin.functions.infix

class InfixFunExample {

    /*
    * Two types of infix functions
    * 1. User defined
    * 2. Standard
    * */
    companion object {

        @JvmStatic
        fun main(arg: Array<String>) {

            val m = math()

            var value = m square  3 //here square is user defined infix fun
            println("user defined infix result is $value")
            println("user defined infix result is ${2 and 4}") //here and is  standard bitwise infix fun
            println("standard infix result is ${--value}") //here -- is standard infix

        }

        class math {
            infix fun square(n: Int): Int {
                return n * n
            }
        }

    }

}