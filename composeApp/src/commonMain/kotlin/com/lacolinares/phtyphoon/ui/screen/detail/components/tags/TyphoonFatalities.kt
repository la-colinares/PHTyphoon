package com.lacolinares.phtyphoon.ui.screen.detail.components.tags

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lacolinares.phtyphoon.ui.theme.VampireBlack
import com.lacolinares.phtyphoon.ui.theme.White
import org.jetbrains.compose.resources.painterResource
import phtyphoon.composeapp.generated.resources.Res
import phtyphoon.composeapp.generated.resources.ic_fatality

@Composable
internal fun TyphoonFatalities(fatalities: String) {
    Box(
        modifier = Modifier
            .wrapContentSize()
            .clip(RoundedCornerShape(4.dp))
            .background(White),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .wrapContentSize()
                .padding(vertical = 4.dp, horizontal = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(Res.drawable.ic_fatality),
                contentDescription = null,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Text(
                text = fatalities,
                color = VampireBlack,
                fontSize = MaterialTheme.typography.titleMedium.fontSize,
                lineHeight = 20.sp
            )
        }
    }
}