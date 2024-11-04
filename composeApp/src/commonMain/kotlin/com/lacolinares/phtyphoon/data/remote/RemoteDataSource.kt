package com.lacolinares.phtyphoon.data.remote

import com.lacolinares.phtyphoon.data.remote.dto.DeadliestTyphoonDTO
import com.lacolinares.phtyphoon.data.remote.dto.DestructiveTyphoonDTO

internal class RemoteDataSource(private val service: PHTyphoonService) {

    suspend fun getDeadliestTyphoons(): List<DeadliestTyphoonDTO> {
        return service.getDeadliestTyphoons()
    }

    suspend fun getDestructiveTyphoons(): List<DestructiveTyphoonDTO> {
        return service.getDestructiveTyphoons()
    }

}