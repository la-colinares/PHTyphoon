package com.lacolinares.phtyphoon.ui.screen.detail.components.tags

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.FlowRowScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun TyphoonTags(content: @Composable (FlowRowScope.(Modifier) -> Unit)) {
    FlowRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        val modifier = Modifier.align(Alignment.CenterVertically)
        content(modifier)
    }
}