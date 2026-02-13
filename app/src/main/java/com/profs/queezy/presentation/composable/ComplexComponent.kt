package com.profs.queezy.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.himanshoe.charty.pie.PieChart
import com.himanshoe.charty.pie.config.LabelConfig
import com.himanshoe.charty.pie.config.PieChartConfig
import com.himanshoe.charty.pie.data.PieData
import com.profs.queezy.R
import com.profs.queezy.data.model.Quiz
import com.profs.queezy.presentation.theme.DarkPink
import com.profs.queezy.presentation.theme.NeutralWhite
import com.profs.queezy.presentation.theme.Pink
import com.profs.queezy.presentation.theme.PinkLighter1
import com.profs.queezy.presentation.theme.PinkLighter2
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
    RecentQuiz(Quiz("Statistics Math Quiz", "Math", 12, 8, R.drawable.quiz_1))
}