package com.example.advancetopicsinkotlin.delegation

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner


/*
This is called class delegation
* Example use case where we want analytics to be not override all the actiivty lifecycle so we can create delegate interface
*  like this and implements in DelegationExampleActivity, So all events get triggered
* */
interface AnalyticsLogger {
    fun registerLifeCycleOwner(owner: LifecycleOwner)
}

class AnalyticsImpl : AnalyticsLogger, LifecycleEventObserver {
    override fun registerLifeCycleOwner(owner: LifecycleOwner) {
        owner.lifecycle.addObserver(this)
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {

        when (event) {

            Lifecycle.Event.ON_RESUME -> {
                println("Triggered the onresume event")
            }

            Lifecycle.Event.ON_START -> {
                println("Triggered the onstart event")
            }

            Lifecycle.Event.ON_PAUSE -> {
                println("Triggered the onPause event")

            }

            Lifecycle.Event.ON_DESTROY -> {
                source.lifecycle.removeObserver(this)
            }

            else -> Unit
        }
    }

}