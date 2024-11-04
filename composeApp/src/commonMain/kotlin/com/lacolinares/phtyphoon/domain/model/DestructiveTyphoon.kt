package com.lacolinares.phtyphoon.domain.model

import kotlinx.serialization.Serializable

@Serializable
internal data class DestructiveTyphoon(
    val rank: Int = -1,
    val stormName: String = "",
    val imageUrl: String = "",
    val season: Int = 0,
    val damage: Damage = Damage(),
    val wikipediaUrl: String = "",
    val description: String = "",
){
    @Serializable
    data class Damage(
        val inPHP: String = "",
        val inUSD: String = ""
    )
}