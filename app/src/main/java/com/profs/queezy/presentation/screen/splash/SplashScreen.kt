package com.profs.queezy.presentation.screen.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.profs.queezy.R
import com.profs.queezy.data.utils.Destinations
import com.profs.queezy.presentation.theme.Primary
import com.profs.queezy.presentation.theme.Typography
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(navController: NavHostController) {

    val offsetManX = remember { Animatable(-1000f) }
    val offsetWomanX = remember { Animatable(1000f) }
    val offsetY = remember { Animatable(0f) }
    val offsetTextY = remember { Animatable(100f) }

    LaunchedEffect(Unit) {
        coroutineScope {
            launch {
                offsetManX.animateTo(-150f, tween(1000))
            }

            launch {
                offsetWomanX.animateTo(150f, tween(1000))
            }
        }

        delay(300)

        coroutineScope {
            launch {
                offsetTextY.animateTo(-1200f, tween(700, easing = FastOutSlowInEasing))
            }

            launch {
                offsetY.animateTo(-2000f, tween(700))
            }
        }

        navController.navigate(Destinations.Home)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Primary),
        contentAlignment = Alignment.Center
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .offset { IntOffset(0, offsetTextY.value.toInt()) },
            contentAlignment = Alignment.BottomCenter
        ) {
            Text("Queezy", style = Typography.titleLarge.copy(fontSize = 36.sp))
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .offset { IntOffset(0, offsetY.value.toInt()) },
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .offset { IntOffset(offsetManX.value.toInt(), 0) },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.image_man),
                    contentDescription = null,
                    modifier = Modifier
                        .size(72.dp)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .offset { IntOffset(offsetWomanX.value.toInt(), 0) },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.image_woman),
                    contentDescription = null,
                    modifier = Modifier
                        .size(96.dp)
                )
            }
        }
    }
}