package com.profs.queezy.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.profs.queezy.R
import com.profs.queezy.data.model.Badge
import com.profs.queezy.data.model.Quiz
import com.profs.queezy.data.model.User
import com.profs.queezy.presentation.theme.NeutralGrey5
import com.profs.queezy.presentation.theme.NeutralWhite
import com.profs.queezy.presentation.theme.Primary
import com.profs.queezy.presentation.theme.Typography

@Composable
fun QuizCard(quiz: Quiz, onClick: () -> Unit) {

    Row(
        Modifier
            .fillMaxWidth()
            .height(80.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(NeutralWhite)
            .border(2.dp, NeutralGrey5, RoundedCornerShape(20.dp))
            .clickable { onClick() }
    ) {
        Row(
            Modifier
                .fillMaxSize()
                .padding(8.dp),
            Arrangement.SpaceBetween,
            Alignment.CenterVertically
        ) {

            Image(
                painterResource(quiz.image),
                null,
                Modifier.size(64.dp),
                contentScale = ContentScale.FillBounds
            )

            Column(Modifier.fillMaxHeight(), Arrangement.Center) {
                Text(quiz.name, style = Typography.displayMedium)

                Spacer(Modifier.height(8.dp))

                Text("${quiz.lesson} • ${quiz.amount} Quizzes", style = Typography.bodyMedium)
            }

            Column(
                Modifier
                    .fillMaxHeight()
                    .padding(end = 8.dp), Arrangement.Center
            ) {
                IconButton(onClick = {}, Modifier.size(24.dp), enabled = false) {
                    Icon(
                        painterResource(R.drawable.icon_more),
                        null,
                        Modifier.fillMaxSize(),
                        Primary
                    )
                }
            }
        }

    }
}

@Preview
@Composable
private fun QuizCardPrev() {
    QuizCard(Quiz("Statistics Math Quiz", "Math", 12, 8, R.drawable.image_quiz_1)) {}
}

@Composable
fun FriendCard(user: User) {

    Row(
        Modifier
            .fillMaxWidth(0.8f)
            .height(60.dp),
        Arrangement.spacedBy(16.dp)
    ) {
        ImageWithFlag(user, 56.dp)

        Column(Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
            Text(
                "${user.firstName} ${user.lastName}",
                style = Typography.displayMedium,
                maxLines = 1
            )

            Spacer(Modifier.height(4.dp))

            Text("${user.rating} points", style = Typography.bodyMedium.copy(fontSize = 14.sp))
        }
    }

}

@Preview
@Composable
private fun FriendCardPreview() {
    FriendCard(
        User(
            "1",
            "Maren",
            "Workman",
            325,
            R.drawable.flag_germany,
            "https://dummyimage.com/400x400/000/fff&text=M"
        )
    )
}

@Composable
fun BadgeCard(badge: Badge, onClick: () -> Unit) {

    IconButton(onClick = { onClick() }, Modifier.size(88.dp), enabled = badge.enabled) {
        Icon(painterResource(badge.image), badge.name, Modifier.fillMaxSize(), Color.Unspecified)
    }

}

@Preview
@Composable
private fun BadgeCardPreview() {
    BadgeCard(Badge("", R.drawable.badge_1, true)) {}
}