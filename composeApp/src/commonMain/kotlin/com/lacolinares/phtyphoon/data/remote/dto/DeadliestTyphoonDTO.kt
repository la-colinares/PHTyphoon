package com.lacolinares.phtyphoon.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class DeadliestTyphoonDTO(
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