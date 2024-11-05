@file:OptIn(ExperimentalLayoutApi::class, ExperimentalLayoutApi::class)

package com.lacolinares.phtyphoon.ui.screen.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.lacolinares.phtyphoon.shared.BrowserClient
import com.lacolinares.phtyphoon.ui.screen.common.BackgroundImage
import com.lacolinares.phtyphoon.ui.screen.detail.components.DamageInfoSection
import com.lacolinares.phtyphoon.ui.screen.detail.components.DescriptionSection
import com.lacolinares.phtyphoon.ui.screen.detail.components.FooterSection
import com.lacolinares.phtyphoon.ui.screen.detail.components.TitleSection
import com.lacolinares.phtyphoon.ui.screen.detail.components.tags.TyphoonCategoryRank
import com.lacolinares.phtyphoon.ui.screen.detail.components.tags.TyphoonFatalities
import com.lacolinares.phtyphoon.ui.screen.detail.components.tags.TyphoonSeason
import com.lacolinares.phtyphoon.ui.screen.detail.components.tags.TyphoonTags
import com.lacolinares.phtyphoon.ui.util.TyphoonType
import com.lacolinares.phtyphoon.ui.util.VerticalSpace
import org.koin.compose.koinInject

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun DetailScreen(type: TyphoonType) {
    val browserClient = koinInject<BrowserClient>()

    val lazyListState = rememberLazyListState()
    LazyColumn(
        state = lazyListState,
        modifier = Modifier.fillMaxWidth()
    ) {
        when (type) {
            is TyphoonType.Deadliest -> {
                val data = type.data
                item { BackgroundImage(lazyListState = lazyListState, imageModel = data.imageUrl) }
                item {
                    DetailContent(
                        title = data.stormName,
                        tags = { modifier ->
                            TyphoonCategoryRank(categoryRank = "#${data.rank} Deadliest", modifier = modifier)
                            TyphoonSeason(season = data.season.toString())
                            TyphoonFatalities(fatalities = data.fatalities)
                        },
                        description = data.description,
                        onReadMore = {
                            browserClient.openUrl(data.wikipediaUrl)
                        }
                    )
                }
            }

            is TyphoonType.Destructive -> {
                val data = type.data
                item { BackgroundImage(lazyListState = lazyListState, imageModel = data.imageUrl) }
                item {
                    DetailContent(
                        title = data.stormName,
                        tags = { modifier ->
                            TyphoonCategoryRank(categoryRank = "#${data.rank} Destructive", modifier = modifier)
                            TyphoonSeason(season = data.season.toString())
                        },
                        damageInfoSection = {
                            VerticalSpace(10)
                            DamageInfoSection(inPHP = data.damage.inPHP, inUSD = data.damage.inUSD)
                        },
                        description = data.description,
                        onReadMore = {
                            browserClient.openUrl(data.wikipediaUrl)
                        }
                    )
                }
            }
        }
    }
}

@Composable
private fun DetailContent(
    title: String,
    tags: @Composable (FlowRowScope.(Modifier) -> Unit),
    damageInfoSection: @Composable () -> Unit = {},
    description: String,
    onReadMore: () -> Unit
) {
    Column(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .graphicsLayer {
                translationY = -400f
            }
    ) {
        TitleSection(title = title)
        VerticalSpace(16)
        TyphoonTags(content = tags)
        damageInfoSection()
        VerticalSpace(24)
        DescriptionSection(description = description)
        VerticalSpace(24)
        FooterSection(onClick = { onReadMore.invoke() })
    }
}