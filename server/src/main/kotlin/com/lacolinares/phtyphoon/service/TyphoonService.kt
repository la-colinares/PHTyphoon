package com.lacolinares.phtyphoon.service

import com.lacolinares.phtyphoon.model.DeadliestTyphoon
import com.lacolinares.phtyphoon.model.DestructiveTyphoon
import com.lacolinares.phtyphoon.repository.DeadliestTyphoonRepository
import com.lacolinares.phtyphoon.repository.DestructiveTyphoonRepository

class TyphoonService(
    private val deadliestTyphoonRepository: DeadliestTyphoonRepository,
    private val destructiveTyphoonRepository: DestructiveTyphoonRepository,
) {

    fun getDeadliestTyphoons(): List<DeadliestTyphoon> {
        return deadliestTyphoonRepository.getDeadliestTyphoons()
    }

    fun getDestructiveTyphoons(): List<DestructiveTyphoon> {
        return destructiveTyphoonRepository.getDestructiveTyphoons()
    }
}