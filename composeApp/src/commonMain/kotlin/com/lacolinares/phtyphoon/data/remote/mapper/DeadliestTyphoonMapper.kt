package com.lacolinares.phtyphoon.data.remote.mapper

import com.lacolinares.phtyphoon.data.remote.model.DeadliestTyphoonDTO
import com.lacolinares.phtyphoon.domain.model.DeadliestTyphoon

fun List<DeadliestTyphoonDTO>.toDeadliestTyphoons(): List<DeadliestTyphoon>{
    return this.map {
        DeadliestTyphoon(
            rank = it.rank,
            stormName = it.stormName,
            season = it.season,
            fatalities = it.fatalities,
            imageName = it.imageName,
            wikipediaUrl = it.wikipediaUrl,
            description = it.description
        )
    }
}