package com.profs.queezy.presentation.screen.leaderboard

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.profs.queezy.R
import com.profs.queezy.data.utils.Storage
import com.profs.queezy.domain.service.DomainServiceImpl
import com.profs.queezy.presentation.composable.AdvancedPageSwitcher
import com.profs.queezy.presentation.composable.LeaderboardCard
import com.profs.queezy.presentation.composable.LeaderboardPodium
import com.profs.queezy.presentation.composable.TopBar
import com.profs.queezy.presentation.theme.DarkYellow
import com.profs.queezy.presentation.theme.LightYellow
import com.profs.queezy.presentation.theme.NeutralGrey4
import com.profs.queezy.presentation.theme.NeutralGrey5
import com.profs.queezy.presentation.theme.Primary
import com.profs.queezy.presentation.theme.Secondary
import com.profs.queezy.presentation.theme.Tertiary
import com.profs.queezy.presentation.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LeaderboardScreen(navController: NavHostController, viewModel: LeaderboardViewModel) {

    val leaderboard = viewModel.leaderboard.collectAsState().value
    val opened = viewModel.opened.collectAsState().value
    val paddingColumn = if (!opened) 620.dp else 180.dp

    Scaffold(
        Modifier.fillMaxSize(),
        containerColor = Primary
    ) { paddingValues ->

        Box(
            Modifier
                .fillMaxSize()
                .paint(
                    painterResource(R.drawable.background_leaderboard),
                    contentScale = ContentScale.FillWidth,
                    alignment = Alignment.BottomCenter
                )
                .padding(paddingValues)
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

                if (!opened) {
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

                    Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.TopEnd) {

                        Box(
                            Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp)
                        ) {
                            if (leaderboard != null && leaderboard.size >= 3) {
                                Box(
                                    Modifier
                                        .fillMaxWidth()
                                        .padding(top = 8.dp)
                                ) {
                                    LeaderboardPodium(
                                        listOf(
                                            leaderboard[0],
                                            leaderboard[1],
                                            leaderboard[2]
                                        )
                                    )
                                }
                            }
                        }

                        Row(
                            Modifier
                                .clip(RoundedCornerShape(12.dp))
                                .background(Tertiary)
                                .padding(horizontal = 12.dp, vertical = 8.dp),
                            Arrangement.spacedBy(4.dp),
                            Alignment.CenterVertically
                        ) {
                            Icon(
                                painterResource(R.drawable.icon_deadline),
                                null,
                                Modifier.size(16.dp),
                                Secondary
                            )

                            Text(
                                "06d 23h 00m",
                                style = Typography.bodyMedium.copy(
                                    color = NeutralGrey4,
                                    fontWeight = FontWeight.Medium
                                )
                            )
                        }


                    }
                }
            }


            Box(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
                    .padding(top = paddingColumn)
                    .clickable { viewModel.saveState(!opened) }
            ) {
                Image(
                    painterResource(R.drawable.background_leaderboard_bottom),
                    null,
                    Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth
                )

                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 44.dp)
                        .clip(RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
                        .background(NeutralGrey5)
                ) {
                    if (leaderboard?.isNotEmpty() == true) {
                        LazyColumn(
                            Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp)
                        ) {
                            items(leaderboard) { item ->
                                LeaderboardCard(
                                    item,
                                    leaderboard.sortedByDescending { it.points }
                                        .indexOfFirst { it.id == item.id }.plus(1)
                                )
                            }
                        }
                    } else {
                        Spacer(Modifier.height(60.dp))
                    }
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