package com.lacolinares.phtyphoon.db

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.lacolinares.phtyphoon.data.local.PHTyphoonDatabase
import kotlinx.coroutines.Dispatchers

fun getDatabaseBuilder(context: Context): PHTyphoonDatabase {
    val appContext = context.applicationContext
    val dbFile = appContext.getDatabasePath("ph_typhoon.db")
    return Room.databaseBuilder<PHTyphoonDatabase>(appContext, dbFile.absolutePath)
        .fallbackToDestructiveMigrationOnDowngrade(false)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}