package com.lacolinares.phtyphoon.ui.screen.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.lacolinares.phtyphoon.ui.theme.VampireBlack
import com.lacolinares.phtyphoon.ui.theme.White

@Composable
fun DetailScreen(param: String) {
    Box(modifier = Modifier.fillMaxSize().background(VampireBlack), contentAlignment = Alignment.Center){
        Text(text = "Detail Screen: $param", color = White)
    }
}