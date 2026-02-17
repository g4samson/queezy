package com.profs.queezy.presentation.screen.leaderboard

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.profs.queezy.R
import com.profs.queezy.data.utils.Storage
import com.profs.queezy.domain.service.DomainServiceImpl
import com.profs.queezy.presentation.composable.AdvancedPageSwitcher
import com.profs.queezy.presentation.composable.TopBar
import com.profs.queezy.presentation.theme.DarkYellow
import com.profs.queezy.presentation.theme.LightYellow
import com.profs.queezy.presentation.theme.Primary
import com.profs.queezy.presentation.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LeaderboardScreen(navController: NavHostController, viewModel: LeaderboardViewModel) {

    Scaffold(
        Modifier.fillMaxSize(),
        containerColor = Primary
    ) { paddingValues ->

        Column(
            Modifier
                .fillMaxSize()
                .paint(
                    painterResource(R.drawable.background_leaderboard),
                    contentScale = ContentScale.FillWidth,
                    alignment = Alignment.BottomCenter
                )
                .padding(paddingValues),
            Arrangement.spacedBy(24.dp)
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .padding(top = 16.dp),
                Arrangement.spacedBy(20.dp),
                Alignment.Start
            ) {

                TopBar("Leaderboard", false, navController)

                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    AdvancedPageSwitcher(listOf("Weekly", "All Time")) {}
                }

                Row(
                    Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(20.dp))
                        .background(LightYellow)
                        .padding(16.dp),
                    Arrangement.spacedBy(16.dp),
                    Alignment.CenterVertically
                ) {
                    Box(
                        Modifier
                            .size(56.dp)
                            .clip(RoundedCornerShape(20.dp))
                            .background(DarkYellow),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("#4", style = Typography.titleLarge)
                    }

                    Text(
                        "You are doing better than\n60% of other players!",
                        style = Typography.bodyLarge
                    )
                }

            }


        }
    }

}

@SuppressLint("ViewModelConstructorInComposable")
@Preview
@Composable
private fun LeaderboardScreenPreview() {
    LeaderboardScreen(rememberNavController(), LeaderboardViewModel(DomainServiceImpl(Storage())))
}