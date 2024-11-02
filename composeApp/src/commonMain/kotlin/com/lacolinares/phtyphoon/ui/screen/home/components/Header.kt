package com.lacolinares.phtyphoon.ui.screen.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lacolinares.phtyphoon.shared.BrowserClient
import com.lacolinares.phtyphoon.ui.theme.HyperLinkColor
import com.lacolinares.phtyphoon.ui.theme.White
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.koinInject
import phtyphoon.composeapp.generated.resources.Res
import phtyphoon.composeapp.generated.resources.read_more_label
import phtyphoon.composeapp.generated.resources.read_more_url
import phtyphoon.composeapp.generated.resources.typhoon_in_the_philippines_description
import phtyphoon.composeapp.generated.resources.typhoon_in_the_philippines_title

@Composable
internal fun Header(){
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