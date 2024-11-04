package com.lacolinares.phtyphoon.ui.util

import com.lacolinares.phtyphoon.domain.model.DeadliestTyphoon
import com.lacolinares.phtyphoon.domain.model.DestructiveTyphoon
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal sealed class TyphoonType {

    @Serializable
    data class Deadliest(@SerialName("deadliest") val data: DeadliestTyphoon): TyphoonType()

    @Serializable
    data class Destructive(@SerialName("destructive") val data: DestructiveTyphoon): TyphoonType()
}