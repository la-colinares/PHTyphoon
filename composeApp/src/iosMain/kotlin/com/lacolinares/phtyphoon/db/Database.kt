package com.lacolinares.phtyphoon.db

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.lacolinares.phtyphoon.data.local.PHTyphoonDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

fun getDatabaseBuilder(): PHTyphoonDatabase {
    val dbFile = documentDirectory() + "/ph_typhoon.db"
    return Room.databaseBuilder<PHTyphoonDatabase>(
        name = dbFile,
    ).setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}

private fun documentDirectory(): String {
    val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
        directory = NSDocumentDirectory,
        inDomain = NSUserDomainMask,
        appropriateForURL = null,
        create = false,
        error = null,
    )
    return requireNotNull(documentDirectory?.path)
}