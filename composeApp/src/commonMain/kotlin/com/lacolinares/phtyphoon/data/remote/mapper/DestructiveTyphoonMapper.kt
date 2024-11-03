package com.lacolinares.phtyphoon.data.remote.mapper

import PHTyphoon.composeApp.BuildConfig
import com.lacolinares.phtyphoon.data.remote.model.DestructiveTyphoonDTO
import com.lacolinares.phtyphoon.domain.model.DestructiveTyphoon

internal fun List<DestructiveTyphoonDTO>.toDestructiveTyphoons(): List<DestructiveTyphoon>{
    return this.map {
        val imageUrl = "${BuildConfig.BASE_URL}resources/typhoon/destructive/${it.imageName}"
        DestructiveTyphoon(
            rank = it.rank,
            stormName = it.stormName,
            imageUrl = imageUrl,
            season = it.season,
            damage = it.damage.toDamage(),
            wikipediaUrl = it.wikipediaUrl,
            description = it.description
        )
    }
}

private fun DestructiveTyphoonDTO.Damage.toDamage(): DestructiveTyphoon.Damage {
    return DestructiveTyphoon.Damage(this.inPHP, this.inUSD)
}