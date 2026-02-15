package com.profs.queezy.presentation.screen.discover

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.profs.queezy.R
import com.profs.queezy.data.utils.Destinations
import com.profs.queezy.data.utils.Storage
import com.profs.queezy.domain.service.DomainServiceImpl
import com.profs.queezy.presentation.composable.AdvancedPageManager
import com.profs.queezy.presentation.composable.CategoryHeader
import com.profs.queezy.presentation.composable.FriendCard
import com.profs.queezy.presentation.composable.QuizCard
import com.profs.queezy.presentation.composable.SearchField
import com.profs.queezy.presentation.composable.TopBar
import com.profs.queezy.presentation.theme.NeutralWhite
import com.profs.queezy.presentation.theme.Primary

@Composable
fun DiscoverScreen(navController: NavHostController, viewModel: DiscoverViewModel) {

    val quizzes = viewModel.quizzes

    val friends = viewModel.friends

    Scaffold(
        Modifier.fillMaxSize(),
        containerColor = Primary
    ) { paddingValues ->

        Column(
            Modifier
                .fillMaxSize()
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

                TopBar("Discover", false, navController)

                SearchField("", "") { }

            }

            Box (Modifier.fillMaxWidth().padding(horizontal = 8.dp)) {
                Image(
                    painterResource(R.drawable.background_discover),
                    null,
                    Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth
                )

                Column(
                    Modifier
                        .fillMaxWidth().padding(top = 37.9.dp)
                        .clip(RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
                        .background(NeutralWhite)
                ) {

                    Column(
                        Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                            .padding(bottom = 14.dp),
                        Arrangement.spacedBy(24.dp),
                        Alignment.CenterHorizontally
                    ) {
                        AdvancedPageManager(listOf("Top", "Quiz", "Categories", "Friends")) {}

                        Column(Modifier.fillMaxWidth(), Arrangement.spacedBy(16.dp)) {
                            CategoryHeader("Quiz", true) { }

                            LazyColumn(
                                Modifier.fillMaxWidth(),
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                items(quizzes) { quiz ->
                                    QuizCard(quiz) { navController.navigate(Destinations.Discover) }
                                }
                            }
                        }

                        Column(Modifier.fillMaxWidth(), Arrangement.spacedBy(16.dp)) {
                            CategoryHeader("Friends", false) { }

                            LazyColumn(
                                Modifier.fillMaxWidth(),
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                items(friends) { user ->
                                    FriendCard(user)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Preview
@Composable
private fun DiscoverScreenPreview() {
    DiscoverScreen(rememberNavController(), DiscoverViewModel(DomainServiceImpl(Storage())))
}