package com.lacolinares.phtyphoon.domain.usecase

import com.lacolinares.phtyphoon.domain.model.DestructiveTyphoon
import com.lacolinares.phtyphoon.domain.repository.PHTyphoonRepository
import kotlinx.coroutines.flow.Flow

internal class GetDestructiveTyphoonUseCase(private val repository: PHTyphoonRepository) {

    suspend operator fun invoke(): Flow<List<DestructiveTyphoon>>{
        return repository.getDestructiveTyphoons()
    }
}
