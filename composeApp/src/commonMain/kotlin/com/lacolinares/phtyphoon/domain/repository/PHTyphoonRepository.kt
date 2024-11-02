package com.lacolinares.phtyphoon.domain.repository

import com.lacolinares.phtyphoon.domain.model.DeadliestTyphoon
import kotlinx.coroutines.flow.Flow

interface PHTyphoonRepository {
    suspend fun getDeadliestTyphoons(): Flow<List<DeadliestTyphoon>>

    suspend fun loadImage(imageName: String, type: String): String
}