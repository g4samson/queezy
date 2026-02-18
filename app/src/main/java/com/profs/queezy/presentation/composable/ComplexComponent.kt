package com.profs.queezy.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.himanshoe.charty.bar.BarChart
import com.himanshoe.charty.bar.config.BarChartConfig
import com.himanshoe.charty.bar.data.BarData
import com.himanshoe.charty.color.ChartyColor
import com.himanshoe.charty.common.config.Animation
import com.himanshoe.charty.common.config.ChartScaffoldConfig
import com.himanshoe.charty.common.config.CornerRadius
import com.himanshoe.charty.pie.PieChart
import com.himanshoe.charty.pie.config.LabelConfig
import com.himanshoe.charty.pie.config.PieChartConfig
import com.himanshoe.charty.pie.config.PieChartStyle
import com.himanshoe.charty.pie.data.PieData
import com.profs.queezy.R
import com.profs.queezy.data.model.Quiz
import com.profs.queezy.data.model.User
import com.profs.queezy.data.model.response.LeaderboardResponseItem
import com.profs.queezy.presentation.theme.Accent1
import com.profs.queezy.presentation.theme.Accent2
import com.profs.queezy.presentation.theme.Accent4
import com.profs.queezy.presentation.theme.Accent5
import com.profs.queezy.presentation.theme.DarkPink
import com.profs.queezy.presentation.theme.LowVisible
import com.profs.queezy.presentation.theme.NeutralBlack
import com.profs.queezy.presentation.theme.NeutralGrey2
import com.profs.queezy.presentation.theme.NeutralGrey6
import com.profs.queezy.presentation.theme.NeutralWhite
import com.profs.queezy.presentation.theme.Pink
import com.profs.queezy.presentation.theme.PinkLighter1
import com.profs.queezy.presentation.theme.PinkLighter2
import com.profs.queezy.presentation.theme.Primary
import com.profs.queezy.presentation.theme.Secondary
import com.profs.queezy.presentation.theme.Typography

@Composable
fun RecentQuiz(quiz: Quiz) {
    val donePercentage = if (quiz.amount == 0) 0f else quiz.done.toFloat() / quiz.amount.toFloat()
    val chartData = listOf(
        PieData("Done", donePercentage, Pink),
        PieData("Rest", 1f - donePercentage, PinkLighter2),
    )

    Row(
        Modifier
            .fillMaxWidth()
            .height(84.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(PinkLighter1)
    ) {
        Box(Modifier.fillMaxSize()) {
            Image(
                painterResource(R.drawable.background_recent),
                null,
                Modifier.fillMaxSize(),
                contentScale = ContentScale.FillWidth
            )

            Row(
                Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp),
                Arrangement.SpaceBetween,
                Alignment.CenterVertically,
            ) {
                Column(Modifier.fillMaxHeight(), Arrangement.Center) {
                    Text(
                        "RECENT QUIZ",
                        style = Typography.headlineSmall.copy(
                            color = DarkPink.copy(0.5f),
                            letterSpacing = 2.sp
                        )
                    )

                    Spacer(Modifier.height(8.dp))

                    Row(
                        Modifier,
                        Arrangement.spacedBy(8.dp),
                        Alignment.CenterVertically
                    ) {
                        Icon(
                            painterResource(R.drawable.icon_headphones),
                            null,
                            Modifier,
                            DarkPink
                        )
                        Text(
                            "A Basic Music Quiz",
                            style = Typography.bodyLarge.copy(color = DarkPink)
                        )

                    }
                }

                Box(modifier = Modifier.size(64.dp), Alignment.Center) {
                    PieChart(
                        { chartData },
                        Modifier.fillMaxSize(),
                        config = PieChartConfig(labelConfig = LabelConfig(shouldShowLabels = false))
                    )

                    Text(
                        "${(donePercentage * 100).toInt()}%",
                        style = Typography.headlineSmall.copy(color = NeutralWhite)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun RecentQuizPreview() {
    RecentQuiz(Quiz("Statistics Math Quiz", "Math", 12, 8, R.drawable.image_quiz_1))
}

@Composable
fun AdvancedPageManager(values: List<String>, onPageChange: (Int) -> Unit) {

    var selected by remember { mutableIntStateOf(0) }

    Row(
        Modifier.fillMaxWidth(),
        Arrangement.SpaceBetween,
        Alignment.CenterVertically
    ) {
        values.forEachIndexed { index, page ->
            Column(
                Modifier,
                Arrangement.Center,
                Alignment.CenterHorizontally
            ) {
                TextButton(onClick = {
                    onPageChange(index)
                    selected = index
                }) {
                    Text(
                        page,
                        style = Typography.headlineSmall.copy(
                            color = if (selected == index) Primary else NeutralGrey2,
                            fontWeight = if (selected == index) FontWeight.Bold else FontWeight.Normal
                        )
                    )
                }

                Box(
                    Modifier
                        .size(6.dp)
                        .clip(CircleShape)
                        .background(if (selected == index) Primary else Color.Transparent)
                )
            }
        }
    }
}

@Preview
@Composable
private fun AdvancedPageManagerPrev() {
    AdvancedPageManager(listOf("Top", "Quiz", "Categories", "Friends")) {}
}

@Composable
fun ProfileQuizInfo() {
    val donePercentage = 0.75f

    val chartData = listOf(
        PieData("Done", donePercentage, Primary),
        PieData("Rest", 1f - donePercentage, NeutralWhite),
    )

    Box(
        Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(Accent4)
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
            Arrangement.Top,
            Alignment.CenterHorizontally
        ) {

            Spacer(Modifier.height(74.dp))

            Text(
                "You have played a total\n24 quizzes this month!",
                style = Typography.titleMedium.copy(textAlign = TextAlign.Center)
            )

            Spacer(Modifier.height(16.dp))

            Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                PieChart(
                    { chartData },
                    Modifier.size(148.dp),
                    config = PieChartConfig(
                        donutHoleRatio = 0.85f,
                        style = PieChartStyle.DONUT,
                        labelConfig = LabelConfig(shouldShowLabels = false)
                    )
                )

                Column(Modifier, Arrangement.Center, Alignment.CenterHorizontally) {
                    Row(Modifier, Arrangement.Center, Alignment.Bottom) {
                        Text(
                            "${(donePercentage * 50).toInt()}",
                            style = Typography.displayMedium.copy(
                                color = NeutralBlack,
                                fontSize = 24.sp
                            )
                        )
                        Text("/50", style = Typography.displayMedium.copy(color = LowVisible))
                    }

                    Text(
                        "quiz played",
                        style = Typography.headlineSmall.copy(
                            color = NeutralBlack.copy(0.5f),
                            fontWeight = FontWeight.Normal
                        )
                    )
                }
            }

            Spacer(Modifier.height(24.dp))

            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                QuizInfoContainer(
                    "Quiz Created",
                    5,
                    R.drawable.icon_create,
                    NeutralWhite,
                    NeutralBlack
                )

                QuizInfoContainer(
                    "Quiz  Won",
                    21,
                    R.drawable.icon_medal,
                    Primary,
                    NeutralWhite
                )
            }

        }

        Image(
            painterResource(R.drawable.background_profile_info),
            null,
            Modifier.fillMaxWidth(0.7f),
            contentScale = ContentScale.FillWidth
        )

        Row(
            Modifier
                .fillMaxWidth()
                .padding(15.dp), Arrangement.End
        ) {
            Row(
                Modifier
                    .clip(RoundedCornerShape(12.dp))
                    .clickable {}
                    .background(NeutralWhite), Arrangement.Center
            ) {

                Row(
                    Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
                    Arrangement.spacedBy(4.dp),
                    Alignment.CenterVertically
                ) {
                    Text(
                        "Monthly",
                        style = Typography.bodyMedium.copy(
                            color = NeutralBlack,
                            fontWeight = FontWeight.Medium
                        )
                    )

                    Icon(
                        painterResource(R.drawable.icon_more_down),
                        null,
                        Modifier.size(16.dp),
                        Primary
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun ProfileQuizInfoPreview() {
    ProfileQuizInfo()
}

@Composable
fun ProfilePerformance() {

    val chartData = listOf(
        BarData("Math", 30f, ChartyColor.Solid(Accent1)),
        BarData("Sports", 80f, ChartyColor.Solid(Accent2)),
        BarData("Music", 60f, ChartyColor.Solid(Accent5)),
    )

    val colors = listOf<Color>(Accent1, Accent2, Accent5)

    Column(
        Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(Primary)
            .padding(16.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            Arrangement.SpaceBetween,
            Alignment.Top
        ) {
            Text(
                "Top performance by\ncategory",
                style = Typography.titleMedium.copy(color = NeutralWhite)
            )

            Box(
                Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(NeutralWhite.copy(0.2f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painterResource(R.drawable.icon_performance),
                    null,
                    Modifier.size(24.dp),
                    NeutralWhite
                )
            }
        }

        Spacer(Modifier.height(16.dp))

        Row(Modifier.fillMaxWidth(), Arrangement.spacedBy(32.dp), Alignment.CenterVertically) {
            chartData.forEachIndexed { index, data ->
                Row(Modifier, Arrangement.spacedBy(8.dp), Alignment.CenterVertically) {
                    Box(
                        Modifier
                            .size(8.dp)
                            .clip(CircleShape)
                            .background(colors[index])
                    )

                    Text(data.label, style = Typography.headlineSmall.copy(NeutralWhite))
                }
            }
        }

        Spacer(Modifier.height(24.dp))

        BarChart(
            { chartData }, barConfig = BarChartConfig(
                barWidthFraction = 0.35f,
                cornerRadius = CornerRadius.Custom(20f),
                animation = Animation.Enabled()
            ), scaffoldConfig = ChartScaffoldConfig(
                showAxis = false,
                gridColor = NeutralWhite.copy(0.2f),
                gridThickness = 2f,
                labelTextStyle = Typography.headlineSmall.copy(color = NeutralWhite)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .height(212.dp)
        )
    }

}

@Preview
@Composable
private fun ProfilePerformancePreview() {
    ProfilePerformance()
}

@Composable
fun AdvancedPageSwitcher(values: List<String>, onPageChange: (Int) -> Unit) {

    var selected by remember { mutableIntStateOf(0) }

    Row(
        Modifier.fillMaxWidth(),
        Arrangement.SpaceBetween,
        Alignment.CenterVertically
    ) {
        values.forEachIndexed { index, page ->
            Button(
                onClick = {
                    onPageChange(index)
                    selected = index
                },
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(20.dp))
                    .background(if (selected == index) Secondary else Primary)
                    .padding(horizontal = 4.dp),
                colors = ButtonDefaults.buttonColors(containerColor = if (selected == index) Secondary else Primary)
            ) {
                Text(
                    page,
                    style = Typography.displayMedium.copy(
                        color = if (selected == index) NeutralWhite else NeutralGrey6,
                        fontWeight = if (selected == index) FontWeight.Medium else FontWeight.Normal
                    )
                )
            }

        }
    }
}

@Preview
@Composable
private fun AdvancedPageSwitcherPrev() {
    AdvancedPageSwitcher(listOf("Weekly", "All Time")) {}
}

@Composable
fun LeaderboardPodium(
    topUsers: List<LeaderboardResponseItem> = listOf(
        LeaderboardResponseItem("1", "Davis", "Curtis", 2569),
        LeaderboardResponseItem("2", "Alena", "Donin", 1469),
        LeaderboardResponseItem("3", "Craig", "Gouse", 1053),
    )
) {

    val first = topUsers[0]
    val second = topUsers[1]
    val third = topUsers[2]

    Row(
        Modifier
            .fillMaxWidth()
            .paint(
                painterResource(R.drawable.background_leaderboard_podium),
                contentScale = ContentScale.FillWidth,
                alignment = Alignment.BottomCenter
            ).padding(horizontal = 16.dp),
        Arrangement.SpaceBetween,
        Alignment.Bottom
    ) {
        Column(
            Modifier.weight(1f).padding(bottom = 170.dp),
            Arrangement.Center,
            Alignment.CenterHorizontally
        ) {
            PodiumUser(
                User(
                    second.id,
                    second.first_name,
                    second.last_name,
                    second.points,
                    R.drawable.flag_france,
                    "https://dummyimage.com/600x400/dedede/c4b2a7.png&text=??"
                ), 2
            )
        }

        Column(
            Modifier.weight(1f).padding(bottom = 210.dp),
            Arrangement.Center,
            Alignment.CenterHorizontally
        ) {
            PodiumUser(
                User(
                    first.id,
                    first.first_name,
                    first.last_name,
                    first.points,
                    R.drawable.flag_fortugal,
                    "https://dummyimage.com/600x400/dedede/c4b2a7.png&text=?"
                ), 1
            )
        }

        Column(
            Modifier.weight(1f).padding(bottom = 130.dp),
            Arrangement.Center,
            Alignment.CenterHorizontally
        ) {
            PodiumUser(
                User(
                    third.id,
                    third.first_name,
                    third.last_name,
                    third.points,
                    R.drawable.flag_canada,
                    "https://dummyimage.com/600x400/dedede/c4b2a7.png&text=???"
                ), 3
            )
        }
    }
}

@Preview
@Composable
private fun LeaderboardPodiumPreview() {
    LeaderboardPodium()
}