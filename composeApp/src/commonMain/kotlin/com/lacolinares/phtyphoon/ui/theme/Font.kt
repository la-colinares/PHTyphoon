package com.lacolinares.phtyphoon.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font
import phtyphoon.composeapp.generated.resources.Montserrat
import phtyphoon.composeapp.generated.resources.Res

@Composable
fun MontFontFamily() = FontFamily(
    Font(Res.font.Montserrat, weight = FontWeight.Light),
    Font(Res.font.Montserrat, weight = FontWeight.Normal),
    Font(Res.font.Montserrat, weight = FontWeight.Medium),
    Font(Res.font.Montserrat, weight = FontWeight.SemiBold),
    Font(Res.font.Montserrat, weight = FontWeight.Bold)
)

@Composable
fun MontTypography() = Typography().run {

    val fontFamily = MontFontFamily()
    copy(
        displayLarge = displayLarge.copy(fontFamily = fontFamily),
        displayMedium = displayMedium.copy(fontFamily = fontFamily),
        displaySmall = displaySmall.copy(fontFamily = fontFamily),
        headlineLarge = headlineLarge.copy(fontFamily = fontFamily),
        headlineMedium = headlineMedium.copy(fontFamily = fontFamily),
        headlineSmall = headlineSmall.copy(fontFamily = fontFamily),
        titleLarge = titleLarge.copy(fontFamily = fontFamily),
        titleMedium = titleMedium.copy(fontFamily = fontFamily),
        titleSmall = titleSmall.copy(fontFamily = fontFamily),
        bodyLarge = bodyLarge.copy(fontFamily =  fontFamily),
        bodyMedium = bodyMedium.copy(fontFamily = fontFamily),
        bodySmall = bodySmall.copy(fontFamily = fontFamily),
        labelLarge = labelLarge.copy(fontFamily = fontFamily),
        labelMedium = labelMedium.copy(fontFamily = fontFamily),
        labelSmall = labelSmall.copy(fontFamily = fontFamily)
    )
}