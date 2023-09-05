package com.example.advancetopicsinkotlin.coroutines

import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.onEach


/*
Source : https://kotlinlang.org/api/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/collect.html
* Buffers flow emissions via channel of a specified capacity and runs collector in a separate coroutine.

Normally, flows are sequential. It means that the code of all operators is executed in the same coroutine.
  For example, consider the following code using onEach and collect operators:
* */
suspend fun main() {

    println("Before buffer")
    flowOf("A", "B", "C")
        .onEach { print(" 1$it ") }
        .collect { print("2$it ") }
    println()
    println("After buffer")
    flowOf("A", "B", "C")
        .onEach { print(" 1$it ") }
        .buffer()  // <--------------- buffer between onEach and collect
        .collect { print(" 2$it ") }


}