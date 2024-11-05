package com.lacolinares.phtyphoon.ui.screen.detail.components.tags

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.lacolinares.phtyphoon.ui.theme.White

@Composable
internal fun TyphoonCategoryRank(categoryRank: String, modifier: Modifier) {
    Text(
        text = categoryRank,
        modifier = Modifier.wrapContentSize().then(modifier),
        color = White,
        fontSize = MaterialTheme.typography.titleMedium.fontSize,
        lineHeight = 20.sp
    )
}