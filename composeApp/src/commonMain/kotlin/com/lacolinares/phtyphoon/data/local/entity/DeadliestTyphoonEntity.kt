package com.lacolinares.phtyphoon.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.lacolinares.phtyphoon.ui.util.Constants

@Entity(tableName = Constants.Database.TABLE_DEADLIEST_TYPHOON)
data class DeadliestTyphoonEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val rank: Int,
    val stormName: String,
    val season: Int,
    val fatalities: String,
    val imageUrl: String,
    val wikipediaUrl: String,
    val description: String
)