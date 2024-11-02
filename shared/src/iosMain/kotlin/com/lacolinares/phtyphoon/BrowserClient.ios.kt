package com.lacolinares.phtyphoon


@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class BrowserClient {
    actual fun openUrl(url: String) {
        val nsUrl = NSURL(string = url)
        if (nsUrl != null) {
            UIApplication.sharedApplication.openURL(nsUrl)
        }
    }
}