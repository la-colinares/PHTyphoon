package com.lacolinares.phtyphoon.ui.screen.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.lacolinares.phtyphoon.ui.theme.VampireBlack
import com.lacolinares.phtyphoon.ui.util.parallaxLayoutModifier
import org.jetbrains.compose.resources.ExperimentalResourceApi
import phtyphoon.composeapp.generated.resources.Res

@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun BackgroundImage(lazyListState: LazyListState) {
    Box(
        modifier = Modifier
            .height(412.dp)
            .fillMaxWidth()
            .parallaxLayoutModifier(lazyListState, 2)
    ) {
        AsyncImage(
            model = Res.getUri("drawable/img_main_typhoon_background.webp"),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .drawWithCache {
                    onDrawWithContent {
                        drawContent()
                        drawRect(
                            Brush.verticalGradient(
                                0f to VampireBlack.copy(alpha = 0F),
                                1F to VampireBlack
                            )
                        )
                    }
                }
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.2f)
                .background(VampireBlack)
        )
    }
}