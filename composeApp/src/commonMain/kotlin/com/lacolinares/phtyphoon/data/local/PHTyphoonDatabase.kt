package com.lacolinares.phtyphoon.data.local

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import com.lacolinares.phtyphoon.data.local.entity.DeadliestTyphoonEntity
import com.lacolinares.phtyphoon.data.local.entity.DestructiveTyphoonEntity

@Database(
    entities = [
        DeadliestTyphoonEntity::class,
        DestructiveTyphoonEntity::class
    ],
    version = 1
)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class PHTyphoonDatabase : RoomDatabase() {
    abstract fun typhoonDao(): PHTyphoonDao
}

// The Room compiler generates the `actual` implementations.
@Suppress("NO_ACTUAL_FOR_EXPECT", "EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<PHTyphoonDatabase> {
    override fun initialize(): PHTyphoonDatabase
}