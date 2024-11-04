package com.lacolinares.phtyphoon.ui.screen.detail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lacolinares.phtyphoon.ui.theme.White

@Composable
internal fun Header(title: String){
    Column(modifier = Modifier.padding(horizontal = 24.dp)){
        Title(title)
        Spacer(Modifier.height(16.dp))
        //Description()
    }
}

@Composable
private fun Title(title: String) {
    Text(
        text = title,
        modifier = Modifier.wrapContentHeight().fillMaxWidth(),
        color = White,
        fontSize = MaterialTheme.typography.headlineLarge.fontSize,
        lineHeight = 40.sp
    )
}