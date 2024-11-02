package com.lacolinares.phtyphoon.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lacolinares.phtyphoon.shared.BrowserClient
import com.lacolinares.phtyphoon.ui.theme.HyperLinkColor
import com.lacolinares.phtyphoon.ui.theme.MontTypography
import com.lacolinares.phtyphoon.ui.theme.VampireBlack
import com.lacolinares.phtyphoon.ui.theme.White
import com.lacolinares.phtyphoon.ui.util.parallaxLayoutModifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject
import phtyphoon.composeapp.generated.resources.Res
import phtyphoon.composeapp.generated.resources.img_main_typhoon_background
import phtyphoon.composeapp.generated.resources.read_more_label
import phtyphoon.composeapp.generated.resources.read_more_url
import phtyphoon.composeapp.generated.resources.typhoon_in_the_philippines_description
import phtyphoon.composeapp.generated.resources.typhoon_in_the_philippines_title

@Composable
@Preview
fun App() {
    MaterialTheme(typography = MontTypography()) {
        Box(modifier = Modifier.fillMaxSize().background(VampireBlack)) {
            Content()
        }
    }
}

@Composable
private fun Content() {
    val lazyListState = rememberLazyListState()
    LazyColumn(
        state = lazyListState,
        modifier = Modifier.fillMaxWidth()
    ){
        item { BackgroundImage(lazyListState) }
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .graphicsLayer {
                        translationY = -400f
                    }
            ) {
                Title()
                Spacer(Modifier.height(16.dp))
                Description()
            }
        }
    }
}

@Composable
private fun BackgroundImage(lazyListState: LazyListState) {
    Box(
        modifier = Modifier
            .height(412.dp)
            .fillMaxWidth()
            .parallaxLayoutModifier(lazyListState, 2)
    ) {
        Image(
            painter = painterResource(Res.drawable.img_main_typhoon_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
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
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.2f)
                .background(VampireBlack)
        )
    }
}

@Composable
private fun Title() {
    Text(
        text = stringResource(Res.string.typhoon_in_the_philippines_title),
        modifier = Modifier.wrapContentHeight().fillMaxWidth(),
        color = White,
        fontSize = MaterialTheme.typography.headlineLarge.fontSize,
        fontWeight = FontWeight.Medium,
        lineHeight = 40.sp
    )
}

@Composable
private fun Description() {
    val browserClient = koinInject<BrowserClient>()

    val description: String = stringResource(Res.string.typhoon_in_the_philippines_description)
    val readMoreLabel: String = stringResource(Res.string.read_more_label)
    val readMoreUrl: String = stringResource(Res.string.read_more_url)

    val annotatedText = buildAnnotatedString {
        append(description)
        append(" ")
        pushStringAnnotation(tag = "URL", annotation = readMoreUrl)
        withStyle(style = SpanStyle(color = HyperLinkColor, fontWeight = FontWeight.Bold)) {
            append(readMoreLabel)
        }
        pop()
    }

    ClickableText(
        text = annotatedText,
        modifier = Modifier.wrapContentHeight().fillMaxWidth(),
        style = TextStyle(
            fontSize = MaterialTheme.typography.bodyMedium.fontSize,
            fontWeight = FontWeight.Medium,
            color = White,
            lineHeight = 20.sp
        ),
        onClick = { offset ->
            // Check if a link was clicked and get its annotation
            annotatedText.getStringAnnotations(tag = "URL", start = offset, end = offset)
                .firstOrNull()?.let { annotation ->
                    browserClient.openUrl(annotation.item)
                }
        },
    )
}