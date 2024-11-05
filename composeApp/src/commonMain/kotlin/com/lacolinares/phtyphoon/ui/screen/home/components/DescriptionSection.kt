package com.lacolinares.phtyphoon.ui.screen.home.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
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

@Composable
internal fun DescriptionSection() {
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
            fontSize = MaterialTheme.typography.labelMedium.fontSize,
            color = White,
            lineHeight = 20.sp
        ),
        onClick = { offset ->
            annotatedText.getStringAnnotations(tag = "URL", start = offset, end = offset)
                .firstOrNull()?.let { annotation ->
                    browserClient.openUrl(annotation.item)
                }
        },
    )
}