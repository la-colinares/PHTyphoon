package com.lacolinares.phtyphoon.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class DestructiveTyphoonDTO(
    val rank: Int = -1,
    @SerialName("storm")
    val stormName: String = "",
    @SerialName("image_name")
    val imageName: String = "",
    val season: Int = 0,
    val damage: Damage = Damage(),
    @SerialName("wikipedia_url")
    val wikipediaUrl: String = "",
    val description: String = "",
){
    @Serializable
    data class Damage(
        val inPHP: String = "",
        val inUSD: String = ""
    )
}