package com.profs.queezy.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.profs.queezy.data.utils.Destinations
import com.profs.queezy.presentation.screen.splash.SplashScreen

@Composable
fun NavigationGraph(navController: NavHostController, modifier: Modifier = Modifier) {

    NavHost(navController, Destinations.Splash) {

        composable<Destinations.Splash> { SplashScreen(navController) }
    }
}