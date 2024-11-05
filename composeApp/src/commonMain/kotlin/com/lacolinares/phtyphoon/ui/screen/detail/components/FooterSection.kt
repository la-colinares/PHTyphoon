package com.lacolinares.phtyphoon.ui.screen.detail.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.lacolinares.phtyphoon.ui.theme.VampireBlack
import com.lacolinares.phtyphoon.ui.theme.White
import org.jetbrains.compose.resources.stringResource
import phtyphoon.composeapp.generated.resources.Res
import phtyphoon.composeapp.generated.resources.read_more_label

@Composable
internal fun FooterSection(onClick: () -> Unit) {
    Button(
        onClick = { onClick.invoke() },
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth(),
        shape = RoundedCornerShape(50),
        colors = ButtonDefaults.buttonColors(
            contentColor = VampireBlack,
            containerColor = White
        ),
        contentPadding = PaddingValues(16.dp)
    ) {
        Text(
            text = stringResource(Res.string.read_more_label),
            fontSize = MaterialTheme.typography.titleMedium.fontSize,
            textAlign = TextAlign.Center
        )
    }
}