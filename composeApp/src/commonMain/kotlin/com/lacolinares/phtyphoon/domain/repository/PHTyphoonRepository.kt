package com.lacolinares.phtyphoon.domain.repository

import com.lacolinares.phtyphoon.domain.model.DeadliestTyphoon
import com.lacolinares.phtyphoon.domain.model.DestructiveTyphoon
import kotlinx.coroutines.flow.Flow

internal interface PHTyphoonRepository {
    suspend fun getDeadliestTyphoons(): Flow<List<DeadliestTyphoon>>
    suspend fun getDestructiveTyphoons(): Flow<List<DestructiveTyphoon>>
}