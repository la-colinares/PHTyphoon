package com.lacolinares.phtyphoon.domain.model

import PHTyphoon.composeApp.BuildConfig

data class DeadliestTyphoon(
    val rank: Int = -1,
    val stormName: String = "",
    val season: Int = 0,
    val fatalities: String = "",
    val imageName: String = "",
    val wikipediaUrl: String = "",
    val description: String = "",
){
    fun getFullImageName(): String {
        return "${BuildConfig.BASE_URL}resources/typhoon/deadliest/$imageName"
    }
}