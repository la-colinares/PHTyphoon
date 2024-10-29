package com.lacolinares.phtyphoon.repository

import com.lacolinares.phtyphoon.model.DeadliestTyphoon
import kotlinx.serialization.json.Json
import java.io.FileNotFoundException

interface DeadliestTyphoonRepository {
    fun getDeadliestTyphoons(): List<DeadliestTyphoon>
}

class DeadliestTyphoonRepositoryImpl : DeadliestTyphoonRepository {

    override fun getDeadliestTyphoons(): List<DeadliestTyphoon> {
        return provideDeadliestTyphoons()
    }

    private fun provideDeadliestTyphoons(): List<DeadliestTyphoon> {
        val deadliestTyphoonJson = javaClass.classLoader.getResource("deadliest_typhoon.json")?.readText()
            ?: throw FileNotFoundException("File not found")
        return Json.decodeFromString(deadliestTyphoonJson)
    }
}