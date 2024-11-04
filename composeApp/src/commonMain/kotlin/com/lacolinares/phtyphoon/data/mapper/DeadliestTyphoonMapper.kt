package com.lacolinares.phtyphoon.data.mapper

import PHTyphoon.composeApp.BuildConfig
import com.lacolinares.phtyphoon.data.local.entity.DeadliestTyphoonEntity
import com.lacolinares.phtyphoon.data.remote.dto.DeadliestTyphoonDTO
import com.lacolinares.phtyphoon.domain.model.DeadliestTyphoon

internal fun List<DeadliestTyphoonDTO>.toDeadliestTyphoonEntityListFromDto(): List<DeadliestTyphoonEntity> {
    return this.map {
        val imageUrl = getImageUrl(it.imageName)
        DeadliestTyphoonEntity(
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

internal fun List<DeadliestTyphoonDTO>.toDeadliestTyphoonsFromDto(): List<DeadliestTyphoon> {
    return this.map {
        val imageUrl = getImageUrl(it.imageName)
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

internal fun List<DeadliestTyphoonEntity>.toDeadliestTyphoonsFromEntityList(): List<DeadliestTyphoon> {
    return this.map {
        DeadliestTyphoon(
            rank = it.rank,
            stormName = it.stormName,
            season = it.season,
            fatalities = it.fatalities,
            imageUrl = it.imageUrl,
            wikipediaUrl = it.wikipediaUrl,
            description = it.description
        )
    }
}

private fun getImageUrl(imageName: String): String = "${BuildConfig.BASE_URL}resources/typhoon/deadliest/$imageName"