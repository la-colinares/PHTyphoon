package com.lacolinares.phtyphoon.ui.screen.detail.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.lacolinares.phtyphoon.ui.theme.White

@Composable
internal fun TitleSection(title: String){
    Text(
        text = title,
        modifier = Modifier.wrapContentHeight().fillMaxWidth(),
        color = White,
        fontSize = MaterialTheme.typography.headlineLarge.fontSize,
        lineHeight = 40.sp
    )
}