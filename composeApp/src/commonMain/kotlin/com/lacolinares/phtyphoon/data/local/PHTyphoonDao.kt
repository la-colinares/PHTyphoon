package com.lacolinares.phtyphoon.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lacolinares.phtyphoon.data.local.entity.DeadliestTyphoonEntity
import com.lacolinares.phtyphoon.data.local.entity.DestructiveTyphoonEntity
import com.lacolinares.phtyphoon.ui.util.Constants


@Dao
interface PHTyphoonDao {

    @Query("SELECT * FROM ${Constants.Database.TABLE_DEADLIEST_TYPHOON}")
    suspend fun getAllDeadliestTyphoons(): List<DeadliestTyphoonEntity>

    @Query("SELECT * FROM ${Constants.Database.TABLE_DESTRUCTIVE_TYPHOON}")
    suspend fun getAllDestructiveTyphoons(): List<DestructiveTyphoonEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDeadliestTyphoons(deadliestTyphoons: List<DeadliestTyphoonEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDestructiveTyphoons(destructiveTyphoons: List<DestructiveTyphoonEntity>)

}