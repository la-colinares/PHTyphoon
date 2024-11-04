package com.lacolinares.phtyphoon.ui.screen.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import com.lacolinares.phtyphoon.ui.screen.common.BackgroundImage
import com.lacolinares.phtyphoon.ui.screen.detail.components.Header
import com.lacolinares.phtyphoon.ui.util.TyphoonType

@Composable
internal fun DetailScreen(type: TyphoonType) {
    var backgroundImage by remember { mutableStateOf("") }
    var title by remember { mutableStateOf("") }

    val lazyListState = rememberLazyListState()
    LazyColumn(
        state = lazyListState,
        modifier = Modifier.fillMaxWidth()
    ){
        when (type) {
            is TyphoonType.Deadliest -> {
                val data = type.data
                backgroundImage = data.imageUrl
                title = data.stormName
            }
            is TyphoonType.Destructive -> {
                val data = type.data
                backgroundImage = data.imageUrl
                title = data.stormName
            }
        }

        if (backgroundImage.isNotEmpty()) {
            item { BackgroundImage(lazyListState, backgroundImage) }
        }
        item {
            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .graphicsLayer {
                        translationY = -400f
                    }
            ){
                Header(title)
            }
        }
    }
}