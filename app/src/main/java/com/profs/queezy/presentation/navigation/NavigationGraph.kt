package com.profs.queezy.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.profs.queezy.data.utils.Destinations
import com.profs.queezy.presentation.screen.discover.DiscoverScreen
import com.profs.queezy.presentation.screen.discover.DiscoverViewModel
import com.profs.queezy.presentation.screen.home.HomeScreen
import com.profs.queezy.presentation.screen.home.HomeViewModel
import com.profs.queezy.presentation.screen.leaderboard.LeaderboardScreen
import com.profs.queezy.presentation.screen.leaderboard.LeaderboardViewModel
import com.profs.queezy.presentation.screen.profile.ProfileScreen
import com.profs.queezy.presentation.screen.profile.ProfileViewModel
import com.profs.queezy.presentation.screen.splash.SplashScreen

@Composable
fun NavigationGraph(navController: NavHostController, modifier: Modifier = Modifier) {

    NavHost(navController, Destinations.Splash) {

        composable<Destinations.Splash> { SplashScreen(navController) }

        composable<Destinations.Home> {
            val viewModel: HomeViewModel = hiltViewModel()
            HomeScreen(navController, viewModel)
        }

        composable<Destinations.Discover> {
            val viewModel: DiscoverViewModel = hiltViewModel()
            DiscoverScreen(navController, viewModel)
        }

        composable<Destinations.Profile> {
            val viewModel: ProfileViewModel = hiltViewModel()
            ProfileScreen(navController, viewModel)
        }

        composable<Destinations.Leaderboard> {
            val viewModel: LeaderboardViewModel = hiltViewModel()
            LeaderboardScreen(navController, viewModel)
        }

    }
}