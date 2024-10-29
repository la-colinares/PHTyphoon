package com.lacolinares.phtyphoon.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DestructiveTyphoon(
    val rank: Int = -1,
    val storm: String = "",
    @SerialName("image_name")
    val imageName: String = "",
    val season: Int = 0,
    val damage: Damage = Damage(),
    @SerialName("wikipedia_url")
    val wikipediaUrl: String = "",
    val description: String
){
    @Serializable
    data class Damage(
        val inPHP: String = "",
        val inUSD: String = "",
    )
}