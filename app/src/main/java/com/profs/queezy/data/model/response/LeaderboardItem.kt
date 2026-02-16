package com.profs.queezy.data.model.response

data class LeaderboardResponse(
    val success: Boolean,
    val leaderboard: List<LeaderboardResponseItem>,
    val count: Int
)

data class LeaderboardResponseItem(
    val id: String,
    val first_name: String,
    val last_name: String,
    val points: Int
)
