package com.lacolinares.phtyphoon.domain.usecase

import com.lacolinares.phtyphoon.domain.model.DeadliestTyphoon
import com.lacolinares.phtyphoon.domain.repository.PHTyphoonRepository
import kotlinx.coroutines.flow.Flow

class GetDeadliestTyphoonUseCase(private val repository: PHTyphoonRepository) {

    suspend operator fun invoke(): Flow<List<DeadliestTyphoon>>{
        return repository.getDeadliestTyphoons()
    }
}
