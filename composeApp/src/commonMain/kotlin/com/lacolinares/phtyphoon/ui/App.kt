package com.lacolinares.phtyphoon.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.lacolinares.phtyphoon.ui.navigation.NavGraph
import com.lacolinares.phtyphoon.ui.theme.MontTypography
import com.lacolinares.phtyphoon.ui.theme.VampireBlack
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme(typography = MontTypography()) {
        val navController = rememberNavController()

        Box(modifier = Modifier.fillMaxSize().background(VampireBlack)) {
            NavGraph(navController)
        }
    }
}