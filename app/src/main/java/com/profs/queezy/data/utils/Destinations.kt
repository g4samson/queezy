package com.profs.queezy.data.utils

import kotlinx.serialization.Serializable

@Serializable
sealed class Destinations {

    @Serializable
    data object Splash : Destinations()

    @Serializable
    data object Home : Destinations()

    @Serializable
    data object Profile : Destinations()

    @Serializable
    data object Discover : Destinations()

    @Serializable
    data object Leaderboard : Destinations()

}