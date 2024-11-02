package com.lacolinares.phtyphoon.shared


@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect class BrowserClient {
    fun openUrl(url: String)
}