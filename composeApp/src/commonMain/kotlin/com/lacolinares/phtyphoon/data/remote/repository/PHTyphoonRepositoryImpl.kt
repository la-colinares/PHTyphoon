package com.lacolinares.phtyphoon.data.remote.repository

import com.lacolinares.phtyphoon.data.remote.PHTyphoonService
import com.lacolinares.phtyphoon.data.remote.mapper.toDeadliestTyphoons
import com.lacolinares.phtyphoon.data.remote.mapper.toDestructiveTyphoons
import com.lacolinares.phtyphoon.domain.model.DeadliestTyphoon
import com.lacolinares.phtyphoon.domain.model.DestructiveTyphoon
import com.lacolinares.phtyphoon.domain.repository.PHTyphoonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class PHTyphoonRepositoryImpl(private val service: PHTyphoonService): PHTyphoonRepository {

    override suspend fun getDeadliestTyphoons(): Flow<List<DeadliestTyphoon>> {
        return flow {
            emit(service.getDeadliestTyphoons().toDeadliestTyphoons())
        }
    }

    override suspend fun getDestructiveTyphoons(): Flow<List<DestructiveTyphoon>> {
        return flow {
            emit(service.getDestructiveTyphoons().toDestructiveTyphoons())
        }
    }
}