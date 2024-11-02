package com.lacolinares.phtyphoon.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Routes {

    @Serializable
    data object HomeScreen : Routes()

    @Serializable
    data class DetailScreen(val data: String) : Routes()
}