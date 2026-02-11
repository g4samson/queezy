package com.profs.queezy.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.profs.queezy.R

val Roboto = FontFamily(
    Font(R.font.roboto_black, FontWeight.Black),
    Font(R.font.roboto_bold, FontWeight.Bold),
    Font(R.font.roboto_semibold, FontWeight.SemiBold),
    Font(R.font.roboto_medium, FontWeight.Medium),
    Font(R.font.roboto_regular, FontWeight.Normal),
    Font(R.font.roboto_light, FontWeight.Light),
)

val Rubik = FontFamily(
    Font(R.font.rubik_black, FontWeight.Black),
    Font(R.font.rubik_bold, FontWeight.Bold),
    Font(R.font.rubik_semibold, FontWeight.SemiBold),
    Font(R.font.rubik_medium, FontWeight.Medium),
    Font(R.font.rubik_regular, FontWeight.Normal),
    Font(R.font.rubik_light, FontWeight.Light),
)

val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = Rubik,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.sp,
        color = NeutralWhite
    )
)