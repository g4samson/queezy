package com.profs.queezy.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.profs.queezy.R

//val Roboto = FontFamily(
//    Font(R.font.roboto_black, FontWeight.Black),
//    Font(R.font.roboto_bold, FontWeight.Bold),
//    Font(R.font.roboto_semibold, FontWeight.SemiBold),
//    Font(R.font.roboto_medium, FontWeight.Medium),
//    Font(R.font.roboto_regular, FontWeight.Normal),
//    Font(R.font.roboto_light, FontWeight.Light),
//)

val Rubik = FontFamily(
    Font(R.font.rubik_black, FontWeight.Black),
    Font(R.font.rubik_bold, FontWeight.Bold),
    Font(R.font.rubik_semibold, FontWeight.SemiBold),
    Font(R.font.rubik_medium, FontWeight.Medium),
    Font(R.font.rubik_regular, FontWeight.Normal),
    Font(R.font.rubik_light, FontWeight.Light),
)

val Typography = Typography(
    titleLarge = TextStyle( // headers of screen
        fontFamily = Rubik,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,
        lineHeight = 36.sp,
        letterSpacing = 0.sp,
        color = NeutralWhite
    ),
    titleMedium = TextStyle( // headers of section
        fontFamily = Rubik,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp,
        color = NeutralBlack
    ),
    displayMedium = TextStyle( // quiz card title
        fontFamily = Rubik,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp,
        color = NeutralBlack
    ),
    bodyLarge = TextStyle(  // recent quiz & featured body
        fontFamily = Rubik,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.sp,
        color = NeutralWhite
    ),
    bodyMedium = TextStyle(  // quiz card body
        fontFamily = Rubik,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.sp,
        color = NeutralGrey2
    ),
    headlineSmall = TextStyle(  // text button's text
        fontFamily = Rubik,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.sp,
        color = Primary,
    ),
)