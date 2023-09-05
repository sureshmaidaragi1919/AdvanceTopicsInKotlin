package com.example.advancetopicsinkotlin.delegation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity

class DelegationExampleActivity : ComponentActivity(), AnalyticsLogger by AnalyticsImpl(),
    DeepLinkHandler by DeepLinkHandlerImpl() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerLifeCycleOwner(this)
        /*   check the logs for events to be triggered, here it doesn't ask you
                 to implement activity lifecycle methods like, onstart, onresume, etc.... that's the beauty  of delegation*/
    }


    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        handleDeepLink(this, intent)
        /*
        * Here you can just pass deeplink intent so handler will process the intent
        * */
    }

}