package com.lacolinares.phtyphoon.data.repository

import com.lacolinares.phtyphoon.data.local.LocalDataSource
import com.lacolinares.phtyphoon.data.mapper.toDeadliestTyphoonEntityListFromDto
import com.lacolinares.phtyphoon.data.mapper.toDeadliestTyphoonsFromDto
import com.lacolinares.phtyphoon.data.mapper.toDeadliestTyphoonsFromEntityList
import com.lacolinares.phtyphoon.data.mapper.toDestructiveTyphoonEntityListFromDto
import com.lacolinares.phtyphoon.data.mapper.toDestructiveTyphoonsFromDto
import com.lacolinares.phtyphoon.data.mapper.toDestructiveTyphoonsFromEntityList
import com.lacolinares.phtyphoon.data.remote.RemoteDataSource
import com.lacolinares.phtyphoon.domain.model.DeadliestTyphoon
import com.lacolinares.phtyphoon.domain.model.DestructiveTyphoon
import com.lacolinares.phtyphoon.domain.repository.PHTyphoonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class PHTyphoonRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
) : PHTyphoonRepository {

    override suspend fun getDeadliestTyphoons(): Flow<List<DeadliestTyphoon>> {
        return flow {
            val localDeadliestTyphoons = localDataSource.getAllDeadliestTyphoons()
            if (localDeadliestTyphoons.isNotEmpty()) {
                emit(localDeadliestTyphoons.toDeadliestTyphoonsFromEntityList())
                return@flow
            }

            val remoteDeadliestTyphoons = remoteDataSource.getDeadliestTyphoons()
            localDataSource.insertDeadliestTyphoons(remoteDeadliestTyphoons.toDeadliestTyphoonEntityListFromDto())
            emit(remoteDeadliestTyphoons.toDeadliestTyphoonsFromDto())
        }
    }

    override suspend fun getDestructiveTyphoons(): Flow<List<DestructiveTyphoon>> {
        return flow {
            val localDestructiveTyphoons = localDataSource.getAllDestructiveTyphoons()
            if (localDestructiveTyphoons.isNotEmpty()) {
                emit(localDestructiveTyphoons.toDestructiveTyphoonsFromEntityList())
                return@flow
            }

            val remoteDestructiveTyphoons = remoteDataSource.getDestructiveTyphoons()
            localDataSource.insertDestructiveTyphoons(remoteDestructiveTyphoons.toDestructiveTyphoonEntityListFromDto())
            emit(remoteDestructiveTyphoons.toDestructiveTyphoonsFromDto())
        }
    }
}