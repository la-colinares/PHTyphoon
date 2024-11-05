package com.lacolinares.phtyphoon.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.lacolinares.phtyphoon.domain.model.DeadliestTyphoon
import com.lacolinares.phtyphoon.domain.model.DestructiveTyphoon
import com.lacolinares.phtyphoon.ui.screen.common.BackgroundImage
import com.lacolinares.phtyphoon.ui.screen.home.components.DeadliestTyphoonListHorizontal
import com.lacolinares.phtyphoon.ui.screen.home.components.DescriptionSection
import com.lacolinares.phtyphoon.ui.screen.home.components.DestructiveTyphoonListHorizontal
import com.lacolinares.phtyphoon.ui.screen.home.components.TitleSection
import com.lacolinares.phtyphoon.ui.util.VerticalSpace
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.koin.compose.viewmodel.koinViewModel
import phtyphoon.composeapp.generated.resources.Res
import phtyphoon.composeapp.generated.resources.top_deadliest_typhoon
import phtyphoon.composeapp.generated.resources.top_destructive_typhoon

@OptIn(ExperimentalResourceApi::class)
@Composable
internal fun HomeScreen(
    onClickDeadliestTyphoon: (DeadliestTyphoon) -> Unit,
    onClickDestructiveTyphoon: (DestructiveTyphoon) -> Unit
) {
    val viewModel = koinViewModel<HomeScreenViewModel>()
    val deadliestTyphoons by viewModel.deadliestTyphoons.collectAsStateWithLifecycle()
    val destructiveTyphoons by viewModel.destructiveTyphoons.collectAsStateWithLifecycle()

    val backgroundImage = Res.getUri("drawable/img_main_typhoon_background.webp")

    val lazyListState = rememberLazyListState()
    LazyColumn(
        state = lazyListState,
        modifier = Modifier.fillMaxWidth()
    ) {
        item { BackgroundImage(lazyListState, backgroundImage) }
        item {
            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .graphicsLayer {
                        translationY = -400f
                    }
            ) {
                Column(modifier = Modifier.padding(horizontal = 24.dp)){
                    TitleSection()
                    VerticalSpace(16)
                    DescriptionSection()
                }
                if (deadliestTyphoons.isNotEmpty()) {
                    VerticalSpace(24)
                    DeadliestTyphoonListHorizontal(
                        title = Res.string.top_deadliest_typhoon,
                        typhoons = deadliestTyphoons,
                        onClick = { typhoon -> onClickDeadliestTyphoon.invoke(typhoon) }
                    )
                }

                if (deadliestTyphoons.isNotEmpty()) {
                    VerticalSpace(24)
                    DestructiveTyphoonListHorizontal(
                        title = Res.string.top_destructive_typhoon,
                        typhoons = destructiveTyphoons,
                        onClick = { typhoon -> onClickDestructiveTyphoon.invoke(typhoon) }
                    )
                }
            }
        }
    }
}