package com.lacolinares.phtyphoon.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import com.lacolinares.phtyphoon.domain.model.DeadliestTyphoon
import com.lacolinares.phtyphoon.ui.screen.home.components.BackgroundImage
import com.lacolinares.phtyphoon.ui.screen.home.components.Header
import com.lacolinares.phtyphoon.ui.theme.VampireBlack
import com.lacolinares.phtyphoon.ui.theme.White
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import phtyphoon.composeapp.generated.resources.Res
import phtyphoon.composeapp.generated.resources.top_deadliest_typhoon

@Composable
fun HomeScreen(
    onClickTyphoon: () -> Unit
) {
    val viewModel = koinViewModel<HomeScreenViewModel>()
    val deadliestTyphoons by viewModel.deadliestTyphoons.collectAsStateWithLifecycle()

    val lazyListState = rememberLazyListState()
    LazyColumn(
        state = lazyListState,
        modifier = Modifier.fillMaxWidth()
    ) {
        item { BackgroundImage(lazyListState) }
        item { Header() }
        if (deadliestTyphoons.isNotEmpty()) {
            item {

                LoadDeadliestTyphoons(viewModel, Res.string.top_deadliest_typhoon, deadliestTyphoons)
            }
        }
    }
}

@Composable
private fun LoadDeadliestTyphoons(
    viewModel: HomeScreenViewModel,
    title: StringResource,
    deadliestTyphoons: List<DeadliestTyphoon>
) {
    Column(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
    ) {
        Text(
            text = stringResource(title),
            modifier = Modifier.wrapContentHeight().fillMaxWidth().padding(horizontal = 24.dp),
            color = White,
            fontSize = MaterialTheme.typography.titleMedium.fontSize,
            fontWeight = FontWeight.Medium,
            lineHeight = 40.sp
        )
        Spacer(modifier = Modifier.height(4.dp))

        val listState = rememberLazyListState()
        val scope = rememberCoroutineScope()
        scope.launch {

        }
        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            state = listState,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(deadliestTyphoons, key = { it.stormName }) { typhoon ->
                println(typhoon.getFullImageName())
                var image by remember { mutableStateOf("") }
                scope.launch {
                    image = viewModel.loadImage(typhoon.imageName, "deadliest")
                }
                Box(
                    modifier = Modifier
                        .height(180.dp)
                        .width(240.dp)
                ) {
                    AsyncImage(
                        model = image,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxSize()
//                            .drawWithCache {
//                                onDrawWithContent {
//                                    drawContent()
//                                    drawRect(
//                                        Brush.verticalGradient(
//                                            0f to VampireBlack.copy(alpha = 0F),
//                                            1F to VampireBlack
//                                        )
//                                    )
//                                }
//                            }
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .alpha(0.2f)
                            .background(VampireBlack)
                    )
                }
            }
        }
    }
}