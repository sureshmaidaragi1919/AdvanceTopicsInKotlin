package com.example.advancetopicsinkotlin.delegation

import android.content.Intent
import androidx.activity.ComponentActivity

interface DeepLinkHandler {
    fun handleDeepLink(activity: ComponentActivity, intent: Intent?)
}


class DeepLinkHandlerImpl : DeepLinkHandler {
    override fun handleDeepLink(activity: ComponentActivity, intent: Intent?) {

        //get activity instance and handled the intent
    }

}