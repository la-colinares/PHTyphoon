package com.lacolinares.phtyphoon.ui.screen.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.lacolinares.phtyphoon.domain.model.DeadliestTyphoon
import com.lacolinares.phtyphoon.domain.model.DestructiveTyphoon
import com.lacolinares.phtyphoon.ui.theme.VampireBlack
import com.lacolinares.phtyphoon.ui.theme.White
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

@Composable
internal fun DeadliestTyphoonHorizontalList(
    title: StringResource,
    typhoons: List<DeadliestTyphoon>
){
    Column(modifier = Modifier.wrapContentHeight().fillMaxWidth()) {
        Title(title)
        Spacer(modifier = Modifier.height(8.dp))
        val listState = rememberLazyListState()
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            state = listState,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(horizontal = 24.dp)
        ) {
            items(typhoons, key = { it.stormName }) { typhoon ->
                ImageContent(typhoon.imageUrl, typhoon.stormName)
            }
        }
    }
}

@Composable
internal fun DestructiveTyphoonHorizontalList(
    title: StringResource,
    typhoons: List<DestructiveTyphoon>
){
    Column(modifier = Modifier.wrapContentHeight().fillMaxWidth()) {
        Title(title)
        Spacer(modifier = Modifier.height(8.dp))
        val listState = rememberLazyListState()
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            state = listState,
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(horizontal = 24.dp)
        ) {
            items(typhoons, key = { it.stormName }) { typhoon ->
                ImageContent(typhoon.imageUrl, typhoon.stormName)
            }
        }
    }
}

@Composable
private fun ImageContent(
    imageUrl: String,
    name: String,
){
    Box(modifier = Modifier.wrapContentSize()) {
        AsyncImage(
            model = imageUrl,
            contentDescription = name,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .height(180.dp)
                .width(240.dp)
                .drawWithCache {
                    onDrawWithContent {
                        drawContent()
                        drawRect(
                            Brush.verticalGradient(
                                0f to VampireBlack.copy(alpha = 0F),
                                1F to VampireBlack
                            )
                        )
                    }
                }
                .clip(RoundedCornerShape(12.dp))
        )
        Text(
            text = name,
            modifier = Modifier.wrapContentHeight()
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 24.dp)
                .align(Alignment.BottomCenter),
            color = White,
            fontSize = MaterialTheme.typography.titleMedium.fontSize,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun Title(title: StringResource){
    Text(
        text = stringResource(title),
        modifier = Modifier.wrapContentHeight().fillMaxWidth().padding(horizontal = 24.dp),
        color = White,
        fontSize = MaterialTheme.typography.titleMedium.fontSize,
        fontWeight = FontWeight.Medium,
    )
}