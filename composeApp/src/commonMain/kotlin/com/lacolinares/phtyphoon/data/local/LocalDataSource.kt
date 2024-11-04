package com.lacolinares.phtyphoon.data.local

import com.lacolinares.phtyphoon.data.local.entity.DeadliestTyphoonEntity
import com.lacolinares.phtyphoon.data.local.entity.DestructiveTyphoonEntity

class LocalDataSource(private val dao: PHTyphoonDao) {

    suspend fun getAllDeadliestTyphoons(): List<DeadliestTyphoonEntity> {
        return dao.getAllDeadliestTyphoons()
    }

    suspend fun getAllDestructiveTyphoons(): List<DestructiveTyphoonEntity> {
        return dao.getAllDestructiveTyphoons()
    }

    suspend fun insertDeadliestTyphoons(deadliestTyphoons: List<DeadliestTyphoonEntity>) {
        dao.insertDeadliestTyphoons(deadliestTyphoons)
    }

    suspend fun insertDestructiveTyphoons(destructiveTyphoons: List<DestructiveTyphoonEntity>) {
        dao.insertDestructiveTyphoons(destructiveTyphoons)
    }
}