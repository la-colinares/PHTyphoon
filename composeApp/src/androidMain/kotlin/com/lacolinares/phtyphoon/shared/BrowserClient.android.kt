package com.lacolinares.phtyphoon.shared

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class BrowserClient(private val context: Context) {
    actual fun openUrl(url: String) {
        val customTabsIntent = CustomTabsIntent.Builder()
            .setUrlBarHidingEnabled(true)
            .build()

        if (context !is Activity){
            customTabsIntent.intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }

        customTabsIntent.launchUrl(context, Uri.parse(url))
    }
}