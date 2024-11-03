package com.lacolinares.phtyphoon.data.remote.mapper

import PHTyphoon.composeApp.BuildConfig
import com.lacolinares.phtyphoon.data.remote.model.DeadliestTyphoonDTO
import com.lacolinares.phtyphoon.domain.model.DeadliestTyphoon

internal fun List<DeadliestTyphoonDTO>.toDeadliestTyphoons(): List<DeadliestTyphoon>{
    return this.map {
        val imageUrl = "${BuildConfig.BASE_URL}resources/typhoon/deadliest/${it.imageName}"
        DeadliestTyphoon(
            rank = it.rank,
            stormName = it.stormName,
            season = it.season,
            fatalities = it.fatalities,
            imageUrl = imageUrl,
            wikipediaUrl = it.wikipediaUrl,
            description = it.description
        )
    }
}