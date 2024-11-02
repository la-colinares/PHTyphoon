package com.lacolinares.phtyphoon.domain.usecase

import com.lacolinares.phtyphoon.domain.repository.PHTyphoonRepository

class GetTyphoonImageUseCase(private val repository: PHTyphoonRepository) {

    suspend operator fun invoke(imageName: String, type: String): String{
        return repository.loadImage(imageName, type)
    }
}
