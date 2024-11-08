package com.lacolinares.phtyphoon.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DeadliestTyphoon(
    val rank: Int = -1,
    @SerialName("storm_name")
    val stormName: String = "",
    val season: Int = 0,
    val fatalities: String = "",
    @SerialName("image_name")
    val imageName: String = "",
    @SerialName("wikipedia_url")
    val wikipediaUrl: String = "",
    val description: String = "",
)