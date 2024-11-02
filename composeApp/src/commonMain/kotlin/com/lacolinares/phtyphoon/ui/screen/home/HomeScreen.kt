package com.lacolinares.phtyphoon.ui.screen.home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.lacolinares.phtyphoon.ui.screen.home.components.BackgroundImage
import com.lacolinares.phtyphoon.ui.screen.home.components.Header

@Composable
fun HomeScreen(
    onClickTyphoon: () -> Unit
) {
    val lazyListState = rememberLazyListState()
    LazyColumn(
        state = lazyListState,
        modifier = Modifier.fillMaxWidth()
    ){
        item { BackgroundImage(lazyListState) }
        item { Header() }
    }
}