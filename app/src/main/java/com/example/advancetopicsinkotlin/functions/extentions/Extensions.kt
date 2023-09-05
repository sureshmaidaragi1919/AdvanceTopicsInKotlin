package com.example.advancetopicsinkotlin.functions.extentions


fun Int.addWith(n: Int): Int {
    return this + n
}

fun <T> Array<T>.updateValue(index: Int, value: T): Array<T> {
    this[index] = value
    return this
}

fun main() {
    println("Two nums added ${2.addWith(3)}")
    val array = arrayOf(1, 2)

    array.updateValue(index = 1, value = 3)
    println("Array updated${array.toList()}")
}