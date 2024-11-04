package com.lacolinares.phtyphoon.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
internal sealed class Routes {

    @Serializable
    internal data object HomeScreen : Routes()

    /**
     * @property type is a [com.lacolinares.phtyphoon.ui.util.TyphoonType] encoded to json string as argument for Detail Screen
     */
    @Serializable
    internal data class DetailScreen(val type: String) : Routes()
}