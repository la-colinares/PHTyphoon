package com.lacolinares.phtyphoon.domain.model

internal data class DeadliestTyphoon(
    val rank: Int = -1,
    val stormName: String = "",
    val season: Int = 0,
    val fatalities: String = "",
    val imageUrl: String = "",
    val wikipediaUrl: String = "",
    val description: String = "",
)