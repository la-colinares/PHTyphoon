package com.lacolinares.phtyphoon.ui.screen.detail.components

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.lacolinares.phtyphoon.ui.theme.White
import com.lacolinares.phtyphoon.ui.util.VerticalSpace

@Composable
internal fun DamageInfoSection(inPHP: String, inUSD: String) {
    Text(
        text = "Damage cost in PHP: $inPHP",
        modifier = Modifier.wrapContentSize(),
        color = White,
        fontSize = MaterialTheme.typography.titleSmall.fontSize,
        lineHeight = 20.sp
    )
    VerticalSpace(4)
    Text(
        text = "Damage cost in USD: $inUSD",
        modifier = Modifier.wrapContentSize(),
        color = White,
        fontSize = MaterialTheme.typography.titleSmall.fontSize,
        lineHeight = 20.sp
    )
}