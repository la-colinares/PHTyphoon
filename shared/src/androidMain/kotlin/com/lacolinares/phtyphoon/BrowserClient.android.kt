package com.lacolinares.phtyphoon

import android.content.Context
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent


@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class BrowserClient(private val context: Context) {
    actual fun openUrl(url: String) {
        val customTabsIntent = CustomTabsIntent.Builder().build()
        customTabsIntent.launchUrl(context, Uri.parse(url))
    }
}