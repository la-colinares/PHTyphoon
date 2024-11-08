package com.lacolinares.phtyphoon.ui.util

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout

internal fun Modifier.parallaxLayoutModifier(scrollState: ScrollState, rate: Int) =
    layout { measurable, constraints ->
        val placeable = measurable.measure(constraints)
        val height = if (rate > 0) scrollState.value / rate else scrollState.value
        layout(placeable.width, placeable.height) {
            placeable.place(0, height)
        }
    }

internal fun Modifier.parallaxLayoutModifier(lazyListState: LazyListState, rate: Int) =
    layout { measurable, constraints ->
        val placeable = measurable.measure(constraints)
        val height = if (rate > 0) lazyListState.firstVisibleItemScrollOffset / rate else lazyListState.firstVisibleItemScrollOffset
        layout(placeable.width, placeable.height) {
            placeable.place(0, height)
        }
    }