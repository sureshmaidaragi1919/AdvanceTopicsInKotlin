package com.example.advancetopicsinkotlin.functions

import com.google.gson.Gson


/*
Asked in halodoc interview

* The purpose of reified is to allow the function to use T at compile time (to access it within the function).

For example:


* */

inline fun <reified T> String.convertToObject(): T {
    val gson = Gson()
    return gson.fromJson(this, T::class.java)
}

fun main() {
    val jsonStringResponse = """{"name":"Suresh" , "age":"24" , "world":"mars"}"""
    val userObject = jsonStringResponse.convertToObject<User>()
    println(userObject.name)
}

data class User(val name: String, val age: Int, val world: String)
