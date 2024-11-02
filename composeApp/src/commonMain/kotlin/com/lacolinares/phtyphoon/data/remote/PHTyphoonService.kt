package com.lacolinares.phtyphoon.data.remote

import com.lacolinares.phtyphoon.data.remote.model.DeadliestTyphoonDTO
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

internal class PHTyphoonService(private val httpClient: HttpClient) {

    suspend fun getDeadliestTyphoons(): List<DeadliestTyphoonDTO> {
       return httpClient
           .get("typhoon/deadliest")
           .body<List<DeadliestTyphoonDTO>>()
    }

    suspend fun getDestructiveTyphoons() {
        //httpClient.get("deadliest")
    }

    suspend fun getImage(imageName: String, type: String): String {
        return httpClient.get("resources/typhoon/$type/$imageName").body<String>()
    }
}