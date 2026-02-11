package com.profs.queezy.presentation.screen.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.glance.layout.Column
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.profs.queezy.data.utils.Destinations
import com.profs.queezy.presentation.theme.Primary
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {

    LaunchedEffect(Unit) {
        delay(800)

        navController.navigate(Destinations.Home)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Primary),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


    }
}