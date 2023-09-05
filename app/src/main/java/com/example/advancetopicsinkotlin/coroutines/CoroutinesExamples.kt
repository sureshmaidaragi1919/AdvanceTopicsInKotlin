package com.example.advancetopicsinkotlin.coroutines

import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis
import kotlin.time.Duration.Companion.seconds


fun main() = runBlocking { //create blocking coroutines that execute in current thread
    /*Code execution is sequential execution*/
    println("syncronous execution start_______________________________________________________________________")

    val timeTaken = measureTimeMillis {
        getMsgOne()
        getMsgTwo()
    }


    println("syncronous execution end_______time taken________$timeTaken")

    //___________________________________________________________________________________________________________________

    println("asynchronous execution starts_______________________________________________________________________")

    val timeTaken1 = measureTimeMillis {
        val one = async {
            getMsgOne()
        }
        val two = async { getMsgTwo() }
        one.await() + two.await()
    }


    println("asynchronous execution end_______time taken________$timeTaken1")
    //___________________________________________________________________________________________________________________

    println("Lazy execution starts_______________________________________________________________________")

    val timeTaken2 = measureTimeMillis {
        val one = async(start = CoroutineStart.LAZY) { getMsgOne() }
        val two = async(start = CoroutineStart.LAZY) { getMsgTwo() }

        one.await() + two.await() //if you comment this line it wont even executes one and two
    }
    println("Lazy execution end_______time taken________$timeTaken2")

    //___________________________________________________________________________________________________________________

    println("Lazy execution starts_______________________________________________________________________")

    val job = launch(Dispatchers.Default) {

        try {
            for (i in 0..50) {
                print(" $i ")
                delay(1.seconds)
            }
        } catch (ex: CancellationException) {
            println("exception ${ex.printStackTrace()}")
        } finally {
            println("Finally")
        }
    }
    job.cancel(CancellationException("Due to manual cancellation"))

}

suspend fun getMsgOne(): String {
    delay(1.seconds)
    return "Msg 1"
}

suspend fun getMsgTwo(): String {
    delay(1.seconds)
    return "Msg 2"
}