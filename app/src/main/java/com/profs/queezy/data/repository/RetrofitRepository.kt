package com.profs.queezy.data.repository

import com.profs.queezy.data.model.response.LeaderboardResponse
import com.profs.queezy.data.model.response.UserResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface RetrofitRepository {

    @GET("functions/v1/get-profile?user_id=224b9ef7-23bd-4b4a-81a4-2405bba67624")
    @Headers("apiKey: sb_publishable_PXsFOzubS8wmEShW0QAiIQ_wwadUt4c")
    suspend fun getProfile(): UserResponse

    @GET("functions/v1/leaderboard")
    @Headers("apiKey: sb_publishable_PXsFOzubS8wmEShW0QAiIQ_wwadUt4c")
    suspend fun getLeaderboard(): LeaderboardResponse

}