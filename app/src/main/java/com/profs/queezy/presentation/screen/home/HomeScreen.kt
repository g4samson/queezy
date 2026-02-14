package com.profs.queezy.presentation.screen.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.profs.queezy.R
import com.profs.queezy.data.model.Quiz
import com.profs.queezy.data.utils.Destinations
import com.profs.queezy.data.utils.Storage
import com.profs.queezy.domain.service.DomainServiceImpl
import com.profs.queezy.presentation.composable.BottomBar
import com.profs.queezy.presentation.composable.FeaturedField
import com.profs.queezy.presentation.composable.QuizCard
import com.profs.queezy.presentation.composable.RecentQuiz
import com.profs.queezy.presentation.theme.Accent1
import com.profs.queezy.presentation.theme.NeutralWhite
import com.profs.queezy.presentation.theme.Primary
import com.profs.queezy.presentation.theme.Typography


@Composable
fun HomeScreen(navController: NavHostController, viewModel: HomeViewModel) {

    val quizzes = viewModel.quizzes

    Scaffold(
        Modifier.fillMaxSize(),
        containerColor = Primary
        //bottomBar = { BottomBar("home", navController) }
    ) { paddingValues ->

        Column(
            Modifier
                .fillMaxSize()
                .padding(paddingValues), Arrangement.spacedBy(24.dp)
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                Arrangement.spacedBy(24.dp),
                Alignment.CenterHorizontally
            ) {
                Row(
                    Modifier.fillMaxWidth(),
                    Arrangement.SpaceBetween,
                    Alignment.CenterVertically
                ) {
                    Column(Modifier, Arrangement.spacedBy(4.dp)) {
                        Row(Modifier, Arrangement.spacedBy(8.dp), Alignment.CenterVertically) {
                            Icon(
                                painterResource(R.drawable.icon_morning),
                                null,
                                Modifier.size(20.dp),
                                Accent1
                            )

                            Text(
                                "GOOD MORNING",
                                style = Typography.bodyMedium.copy(
                                    color = Accent1,
                                    letterSpacing = 2.sp
                                )
                            )
                        }

                        //get data
                        Text("Madelyn Dias", style = Typography.titleLarge)
                    }

                    //async image
                    Image(
                        painterResource(R.drawable.test_media),
                        null,
                        Modifier.size(56.dp),
                        contentScale = ContentScale.FillBounds
                    )
                }

                RecentQuiz(Quiz("Statistics Math Quiz", "Math", 12, 10, R.drawable.quiz_1))

                FeaturedField { navController.navigate(Destinations.Discover) }
            }

            Column(
                Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                    .background(NeutralWhite)
            ) {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 24.dp)
                        .padding(top = 24.dp),
                    Arrangement.spacedBy(16.dp),
                    Alignment.CenterHorizontally
                ) {
                    Row(
                        Modifier.fillMaxWidth(),
                        Arrangement.SpaceBetween,
                        Alignment.CenterVertically
                    ) {
                        Text("Live Quizzes", style = Typography.titleMedium)

                        TextButton({}) {
                            Text("See all", style = Typography.headlineSmall)
                        }
                    }

                    LazyColumn(
                        Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(quizzes) { quiz ->
                            QuizCard(quiz)
                        }

                        item { Spacer(Modifier.height(100.dp)) }
                    }
                }
            }
        }

        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
            BottomBar("home", navController)
        }
    }
}

@SuppressLint("ViewModelConstructorInComposable")
@Preview
@Composable
private fun HomePreview() {
    HomeScreen(rememberNavController(), HomeViewModel(DomainServiceImpl(Storage())))
}