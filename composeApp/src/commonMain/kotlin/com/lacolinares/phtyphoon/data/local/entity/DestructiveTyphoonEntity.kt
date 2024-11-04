package com.lacolinares.phtyphoon.data.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.lacolinares.phtyphoon.data.remote.dto.DestructiveTyphoonDTO.Damage
import com.lacolinares.phtyphoon.ui.util.Constants

@Entity(tableName = Constants.Database.TABLE_DESTRUCTIVE_TYPHOON)
data class DestructiveTyphoonEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val rank: Int,
    val stormName: String,
    val imageUrl: String,
    val season: Int,
    @Embedded
    val damage: Damage,
    val wikipediaUrl: String,
    val description: String,
){
    data class Damage(
        val inPHP: String = "",
        val inUSD: String = ""
    )
}