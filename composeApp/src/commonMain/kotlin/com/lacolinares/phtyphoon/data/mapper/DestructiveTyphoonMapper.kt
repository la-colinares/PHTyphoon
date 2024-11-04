package com.lacolinares.phtyphoon.data.mapper

import PHTyphoon.composeApp.BuildConfig
import com.lacolinares.phtyphoon.data.local.entity.DestructiveTyphoonEntity
import com.lacolinares.phtyphoon.data.remote.dto.DestructiveTyphoonDTO
import com.lacolinares.phtyphoon.domain.model.DestructiveTyphoon

internal fun List<DestructiveTyphoonDTO>.toDestructiveTyphoonEntityListFromDto(): List<DestructiveTyphoonEntity> {
    return this.map {
        val imageUrl = getImageUrl(it.imageName)
        DestructiveTyphoonEntity(
            rank = it.rank,
            stormName = it.stormName,
            season = it.season,
            damage = it.damage.toDamageEntity(),
            imageUrl = imageUrl,
            wikipediaUrl = it.wikipediaUrl,
            description = it.description
        )
    }
}

internal fun List<DestructiveTyphoonDTO>.toDestructiveTyphoonsFromDto(): List<DestructiveTyphoon> {
    return this.map {
        val imageUrl = getImageUrl(it.imageName)
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

internal fun List<DestructiveTyphoonEntity>.toDestructiveTyphoonsFromEntityList(): List<DestructiveTyphoon> {
    return this.map {
        DestructiveTyphoon(
            rank = it.rank,
            stormName = it.stormName,
            imageUrl = it.imageUrl,
            season = it.season,
            damage = it.damage.toDamage(),
            wikipediaUrl = it.wikipediaUrl,
            description = it.description
        )
    }
}

private fun DestructiveTyphoonDTO.Damage.toDamageEntity(): DestructiveTyphoonEntity.Damage {
    return DestructiveTyphoonEntity.Damage(this.inPHP, this.inUSD)
}

private fun DestructiveTyphoonEntity.Damage.toDamage(): DestructiveTyphoon.Damage {
    return DestructiveTyphoon.Damage(this.inPHP, this.inUSD)
}

private fun DestructiveTyphoonDTO.Damage.toDamage(): DestructiveTyphoon.Damage {
    return DestructiveTyphoon.Damage(this.inPHP, this.inUSD)
}

private fun getImageUrl(imageName: String): String = "${BuildConfig.BASE_URL}resources/typhoon/destructive/$imageName"