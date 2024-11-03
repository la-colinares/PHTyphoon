package com.lacolinares.phtyphoon.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import coil3.ImageLoader
import coil3.compose.setSingletonImageLoaderFactory
import coil3.disk.DiskCache
import coil3.request.CachePolicy
import coil3.request.crossfade
import com.lacolinares.phtyphoon.ui.navigation.NavGraph
import com.lacolinares.phtyphoon.ui.theme.MontTypography
import com.lacolinares.phtyphoon.ui.theme.VampireBlack
import okio.FileSystem
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme(typography = MontTypography()) {
        setSingletonImageLoaderFactory { context ->
            ImageLoader.Builder(context)
                .diskCachePolicy(CachePolicy.ENABLED)
                .networkCachePolicy(CachePolicy.ENABLED)
                .diskCache {
                    DiskCache.Builder().directory(FileSystem.SYSTEM_TEMPORARY_DIRECTORY / "image_cache")
                        .maxSizeBytes(512L * 1024 * 1024) // 512MB
                        .build()
                }
                .crossfade(true)
                .build()
        }

        val navController = rememberNavController()

        Box(modifier = Modifier.fillMaxSize().background(VampireBlack)) {
            NavGraph(navController)
        }
    }
}