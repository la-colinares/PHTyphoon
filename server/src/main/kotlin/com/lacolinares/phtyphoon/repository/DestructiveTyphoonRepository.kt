package com.lacolinares.phtyphoon.repository

import com.lacolinares.phtyphoon.model.DestructiveTyphoon
import kotlinx.serialization.json.Json
import java.io.FileNotFoundException

interface DestructiveTyphoonRepository {
    fun getDestructiveTyphoons(): List<DestructiveTyphoon>
}

class DestructiveTyphoonRepositoryImpl : DestructiveTyphoonRepository {

    override fun getDestructiveTyphoons(): List<DestructiveTyphoon> {
        val destructiveTyphoonJson = javaClass.classLoader.getResource("destructive_typhoon.json")?.readText()
            ?: throw FileNotFoundException("File not found")
        return Json.decodeFromString(destructiveTyphoonJson)
    }
}