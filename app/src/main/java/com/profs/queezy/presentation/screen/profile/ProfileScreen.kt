package com.profs.queezy.presentation.screen.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.profs.queezy.R
import com.profs.queezy.data.utils.Storage
import com.profs.queezy.domain.service.DomainServiceImpl
import com.profs.queezy.presentation.composable.AdvancedPageManager
import com.profs.queezy.presentation.composable.BadgeCard
import com.profs.queezy.presentation.composable.BottomBar
import com.profs.queezy.presentation.composable.ImageWithFlag
import com.profs.queezy.presentation.composable.ProfileInfo
import com.profs.queezy.presentation.composable.ProfilePerformance
import com.profs.queezy.presentation.composable.ProfileQuizInfo
import com.profs.queezy.presentation.composable.TopBar
import com.profs.queezy.presentation.theme.NeutralBlack
import com.profs.queezy.presentation.theme.NeutralWhite
import com.profs.queezy.presentation.theme.Primary
import com.profs.queezy.presentation.theme.Typography

@Composable
fun ProfileScreen(navController: NavHostController, viewModel: ProfileViewModel) {

    val userData = viewModel.userData.collectAsState().value
    val page = viewModel.page.collectAsState().value
    val rank = viewModel.rank.collectAsState().value
    val badges = viewModel.badges

    Scaffold(
        Modifier.fillMaxSize(),
        containerColor = Primary
    ) { paddingValues ->

        Column(
            Modifier
                .fillMaxSize()
                .paint(
                    painterResource(R.drawable.background_profile),
                    contentScale = ContentScale.FillWidth
                )
                .padding(paddingValues),
            Arrangement.spacedBy(24.dp)
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
                    .padding(top = 16.dp),
                Arrangement.spacedBy(16.dp),
                Alignment.Start
            ) {

                TopBar("", true, navController)

            }

            Box(
                Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopCenter
            ) {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 68.dp)
                        .padding(horizontal = 8.dp)
                        .clip(RoundedCornerShape(32.dp))
                        .background(NeutralWhite)
                ) {
                    Column(
                        Modifier
                            .fillMaxWidth()
                            .requiredHeight(1165.dp)
                            .padding(horizontal = 16.dp),
                        Arrangement.spacedBy(16.dp),
                        Alignment.CenterHorizontally
                    ) {

                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(top = 48.dp),
                            Arrangement.spacedBy(24.dp),
                            Alignment.CenterHorizontally
                        ) {
                            Text(
                                "${userData?.firstName} ${userData?.lastName}",
                                style = Typography.titleLarge.copy(color = NeutralBlack)
                            )
                        }

                        if (userData != null && rank != null) {
                            ProfileInfo(userData, rank)
                        } else {
                            Text("Loading...", style = Typography.bodyMedium)
                        }

                        Column(
                            Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 32.dp)
                        ) {
                            AdvancedPageManager(
                                listOf(
                                    "Badge",
                                    "Stats",
                                    "Details"
                                )
                            ) { viewModel.savePage(it) }
                        }

                        if (page == 0) {
                            LazyVerticalGrid(
                                GridCells.Fixed(3),
                                Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 8.dp)
                                    .padding(bottom = 24.dp),
                                verticalArrangement = Arrangement.spacedBy(24.dp),
                                horizontalArrangement = Arrangement.spacedBy(24.dp),
                                userScrollEnabled = false
                            ) {
                                items(badges) { badge ->
                                    BadgeCard(badge) { }
                                }
                            }
                        }

                        if (page == 1) {
                            ProfileQuizInfo()

                            ProfilePerformance()
                        }
                    }
                }

                userData?.let { data ->
                    ImageWithFlag(data, 96.dp)
                }
            }

        }

        if (page == 0) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
                BottomBar("home", navController)
            }
        }
    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Preview
@Composable
private fun ProfileScreenPreview() {
    ProfileScreen(rememberNavController(), ProfileViewModel(DomainServiceImpl(Storage())))
}