package com.lacolinares.phtyphoon

import androidx.compose.ui.window.ComposeUIViewController
import com.lacolinares.phtyphoon.di.initKoin
import com.lacolinares.phtyphoon.ui.App

fun MainViewController() = ComposeUIViewController(
    configure = { initKoin() }
) { App() }