package com.lacolinares.phtyphoon.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.lacolinares.phtyphoon.ui.screen.home.components.BackgroundImage
import com.lacolinares.phtyphoon.ui.screen.home.components.DeadliestTyphoonHorizontalList
import com.lacolinares.phtyphoon.ui.screen.home.components.DestructiveTyphoonHorizontalList
import com.lacolinares.phtyphoon.ui.screen.home.components.Header
import org.koin.compose.viewmodel.koinViewModel
import phtyphoon.composeapp.generated.resources.Res
import phtyphoon.composeapp.generated.resources.top_deadliest_typhoon
import phtyphoon.composeapp.generated.resources.top_destructive_typhoon

@Composable
internal fun HomeScreen(
    onClickDeadliestTyphoon: () -> Unit,
    onClickDestructiveTyphoon: () -> Unit
) {
    val viewModel = koinViewModel<HomeScreenViewModel>()
    val deadliestTyphoons by viewModel.deadliestTyphoons.collectAsStateWithLifecycle()
    val destructiveTyphoons by viewModel.destructiveTyphoons.collectAsStateWithLifecycle()

    val lazyListState = rememberLazyListState()
    LazyColumn(
        state = lazyListState,
        modifier = Modifier.fillMaxWidth()
    ) {
        item { BackgroundImage(lazyListState) }
        item {
            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .graphicsLayer {
                        translationY = -400f
                    }
            ) {
                Header()
                if (deadliestTyphoons.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(24.dp))
                    DeadliestTyphoonHorizontalList(Res.string.top_deadliest_typhoon, deadliestTyphoons)
                }

                if (deadliestTyphoons.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(24.dp))
                    DestructiveTyphoonHorizontalList(Res.string.top_destructive_typhoon, destructiveTyphoons)
                }
            }
        }
    }
}