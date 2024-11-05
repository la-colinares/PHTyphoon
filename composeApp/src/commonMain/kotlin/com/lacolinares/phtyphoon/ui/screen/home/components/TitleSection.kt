package com.lacolinares.phtyphoon.ui.screen.home.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.lacolinares.phtyphoon.ui.theme.White
import org.jetbrains.compose.resources.stringResource
import phtyphoon.composeapp.generated.resources.Res
import phtyphoon.composeapp.generated.resources.typhoon_in_the_philippines_title

@Composable
internal fun TitleSection() {
    Text(
        text = stringResource(Res.string.typhoon_in_the_philippines_title),
        modifier = Modifier.wrapContentHeight().fillMaxWidth(),
        color = White,
        fontSize = MaterialTheme.typography.headlineLarge.fontSize,
        lineHeight = 40.sp
    )
}