package com.lacolinares.phtyphoon.ui.util

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun VerticalSpace(height: Int = 0) {
    Spacer(modifier = Modifier.height(height.dp))
}

@Composable
fun VerticalSpace(height: Dp = 0.dp) {
    Spacer(modifier = Modifier.height(height))
}

@Composable
fun HorizontalSpace(width: Int = 0) {
    Spacer(modifier = Modifier.width(width.dp))
}

@Composable
fun HorizontalSpace(width: Dp = 0.dp) {
    Spacer(modifier = Modifier.width(width))
}