package com.profs.queezy.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.profs.queezy.R
import com.profs.queezy.data.model.User
import com.profs.queezy.presentation.theme.Accent3
import com.profs.queezy.presentation.theme.NeutralBlack
import com.profs.queezy.presentation.theme.NeutralGrey4
import com.profs.queezy.presentation.theme.NeutralWhite
import com.profs.queezy.presentation.theme.Primary
import com.profs.queezy.presentation.theme.Secondary
import com.profs.queezy.presentation.theme.Typography

@Composable
fun FeaturedField(onClick: () -> Unit) {

    Box(
        Modifier
            .fillMaxWidth()
            .height(232.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Secondary.copy(0.75f))
    ) {
        Box(
            Modifier.fillMaxSize()
        ) {
            Image(
                painterResource(R.drawable.background_featured),
                null,
                Modifier.fillMaxSize(),
                contentScale = ContentScale.FillWidth
            )
        }
        Box(
            Modifier
                .fillMaxSize()
                .padding(start = 16.dp, top = 16.dp),
            Alignment.TopStart
        ) {
            Image(
                painterResource(R.drawable.image_man),
                null,
                Modifier.size(48.dp),
                contentScale = ContentScale.FillBounds
            )
        }

        Box(
            Modifier
                .fillMaxSize()
                .padding(end = 16.dp, bottom = 42.dp),
            Alignment.BottomEnd
        ) {
            Image(
                painterResource(R.drawable.image_woman),
                null,
                Modifier.size(64.dp),
                contentScale = ContentScale.FillWidth
            )
        }

        Column(
            Modifier
                .fillMaxSize()
                .padding(horizontal = 64.dp),
            Arrangement.Center,
            Alignment.CenterHorizontally
        ) {
            Text(
                "FEATURED", style = Typography.headlineSmall.copy(
                    color = NeutralWhite.copy(0.5f),
                    letterSpacing = 2.sp
                )
            )

            Spacer(Modifier.height(16.dp))

            Text(
                "Take part in challenges with friends or other players",
                style = Typography.bodyLarge.copy(textAlign = TextAlign.Center)
            )

            Spacer(Modifier.height(16.dp))

            Row(
                Modifier
                    .fillMaxWidth(0.6f)
                    .height(44.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(NeutralWhite)
                    .clickable { onClick() },
                Arrangement.Center,
                Alignment.CenterVertically
            ) {
                Icon(painterResource(R.drawable.icon_find), null, Modifier.size(20.dp), Primary)

                Spacer(Modifier.width(10.dp))

                Text("Find Friends", style = Typography.headlineSmall)
            }
        }
    }
}

@Preview
@Composable
private fun FeaturedFieldPreview() {
    FeaturedField {}
}

@Composable
fun SearchField(label: String = "", value: String, onValueChange: (String) -> Unit) {

    var textFieldValue = value

    OutlinedTextField(
        textFieldValue,
        {
            textFieldValue = it
            onValueChange(it)
        },
        Modifier
            .height(56.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Accent3)
            .border(1.dp, Secondary, RoundedCornerShape(20.dp)),
        textStyle = Typography.displayMedium,
        leadingIcon = {
            Icon(
                painterResource(R.drawable.icon_search), null,
                Modifier.size(24.dp), NeutralWhite
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = Accent3,
            focusedContainerColor = Accent3,
            unfocusedTextColor = NeutralGrey4,
            focusedTextColor = NeutralGrey4,
            cursorColor = NeutralGrey4
        )
    )

}

@Preview
@Composable
private fun SearchFieldPreview() {
    SearchField("", "") {}
}

@Composable
fun CategoryHeader(title: String, more: Boolean = false, onClick: () -> Unit) {

    Row(
        Modifier.fillMaxWidth(),
        Arrangement.SpaceBetween,
        Alignment.CenterVertically
    ) {
        Text(title, style = Typography.titleMedium)


        TextButton({ onClick() }, enabled = more) {
            if (more) {
                Text("See all", style = Typography.headlineSmall)
            }
        }

    }

}

@Preview
@Composable
private fun CategoryHeaderPreview() {
    CategoryHeader("Live Quizzes", true) {}
}


@Composable
fun ImageWithFlag(user: User, size: Dp) {

    Box(Modifier.size(size + 4.dp)) {
        AsyncImage(
            user.image,
            null,
            Modifier
                .size(size)
                .clip(CircleShape),
            contentScale = ContentScale.FillBounds
        )

        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd) {
            Icon(
                painterResource(user.countryFlag),
                null,
                Modifier
                    .size(20.dp)
                    .clip(RoundedCornerShape(6.dp)),
                Color.Unspecified
            )
        }
    }
}

@Preview
@Composable
private fun ImageWithFlagPreview() {
    ImageWithFlag(
        User("", "", "", 0, R.drawable.flag_ireland, "R.drawable.image_test_media"),
        96.dp
    )
}

@Composable
fun ProfileInfo(user: User, rank: Int) {

    Row(
        Modifier
            .fillMaxWidth()
            .height(101.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Primary),
        Arrangement.SpaceEvenly,
        Alignment.CenterVertically
    ) {

        Column(
            Modifier.fillMaxHeight(),
            Arrangement.Center,
            Alignment.CenterHorizontally
        ) {

            Icon(
                painterResource(R.drawable.icon_star),
                null,
                Modifier.size(24.dp),
                NeutralWhite
            )

            Text(
                "POINTS", Modifier.padding(vertical = 3.dp),
                style = Typography.bodyMedium.copy(
                    color = NeutralWhite.copy(0.5f),
                    letterSpacing = 2.sp, fontWeight = FontWeight.Medium
                )
            )

            Text(
                "${user.rating}",
                style = Typography.displayMedium.copy(
                    color = NeutralWhite,
                    fontWeight = FontWeight.Bold
                )
            )

        }


        Row(
            Modifier.fillMaxHeight(),
            Arrangement.spacedBy(12.dp),
            Alignment.CenterVertically
        ) {
            VerticalDivider(
                Modifier
                    .fillMaxHeight()
                    .padding(vertical = 16.dp),
                1.dp,
                NeutralWhite.copy(0.5f)
            )

            Column(
                Modifier.fillMaxHeight(),
                Arrangement.Center,
                Alignment.CenterHorizontally
            ) {
                Icon(
                    painterResource(R.drawable.icon_world),
                    null,
                    Modifier.size(24.dp),
                    NeutralWhite
                )

                Text(
                    "WORLD RANK", Modifier.padding(vertical = 3.dp),
                    style = Typography.bodyMedium.copy(
                        color = NeutralWhite.copy(0.5f),
                        letterSpacing = 2.sp, fontWeight = FontWeight.Medium
                    )
                )

                Text(
                    "$rank",
                    style = Typography.displayMedium.copy(
                        color = NeutralWhite,
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            VerticalDivider(
                Modifier
                    .fillMaxHeight()
                    .padding(vertical = 16.dp),
                1.dp,
                NeutralWhite.copy(0.5f)
            )
        }

        Column(
            Modifier.fillMaxHeight(),
            Arrangement.Center,
            Alignment.CenterHorizontally
        ) {

            Icon(
                painterResource(R.drawable.icon_local),
                null,
                Modifier.size(24.dp),
                NeutralWhite
            )

            Text(
                "LOCAL RANK", Modifier.padding(vertical = 3.dp),
                style = Typography.bodyMedium.copy(
                    color = NeutralWhite.copy(0.5f),
                    letterSpacing = 2.sp, fontWeight = FontWeight.Medium
                )
            )

            Text(
                "#56",
                style = Typography.displayMedium.copy(
                    color = NeutralWhite,
                    fontWeight = FontWeight.Bold
                )
            )

        }

    }
}

@Preview
@Composable
private fun ProfileInfoPreview() {
    ProfileInfo(User("", "", "", 590, R.drawable.flag_ireland, "R.drawable.image_test_media"), 1438)
}

@Composable
fun QuizInfoContainer(title: String, number: Int, icon: Int, bgColor: Color, textColor: Color) {

    Box(
        Modifier
            .width(140.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(bgColor)
            .padding(16.dp),
        contentAlignment = Alignment.TopEnd
    ) {
        Column(Modifier.fillMaxWidth(), Arrangement.Center, Alignment.Start) {
            Text(
                "$number", style = Typography.displayMedium.copy(
                    color = textColor,
                    fontSize = 24.sp
                )
            )

            Text(
                title,
                style = Typography.headlineSmall.copy(
                    color = textColor,
                    fontWeight = FontWeight.Normal
                )
            )
        }

        Icon(
            painterResource(icon),
            null,
            Modifier.size(24.dp),
            textColor
        )
    }

}

@Preview
@Composable
private fun QuizInfoContainerPreview() {
    QuizInfoContainer("Quiz Created", 5, R.drawable.icon_create, NeutralWhite, NeutralBlack)
}

@Composable
fun PodiumUser(user: User, place: Int) {

    Column(Modifier, Arrangement.Top, Alignment.CenterHorizontally) {

        Box(Modifier, contentAlignment = Alignment.TopCenter) {

            Column(
                Modifier.padding(top = 24.dp),
                Arrangement.Top,
                Alignment.CenterHorizontally
            ) {
                ImageWithFlag(user, 56.dp)
            }

            Image(
                painterResource(
                    when (place) {
                        1 -> R.drawable.medal_gold
                        2 -> R.drawable.medal_silver
                        3 -> R.drawable.medal_bronze
                        else -> 1
                    }
                ), null,
                Modifier.size(40.dp),
                contentScale = ContentScale.FillBounds
            )
        }

        Spacer(Modifier.height(16.dp))

        Text(
            "${user.firstName} ${user.lastName}",
            style = Typography.displayMedium.copy(color = NeutralWhite)
        )

        Spacer(Modifier.height(4.dp))

        Box(
            Modifier
                .size(width = 75.dp, height = 35.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Secondary),
            contentAlignment = Alignment.Center
        ) {
            Text(
                "${user.rating} QP",
                maxLines = 1,
                style = Typography.bodyMedium.copy(
                    color = NeutralWhite,
                    fontWeight = FontWeight.Medium
                )
            )
        }

        Spacer(Modifier.height(8.dp))

    }

}

@Preview
@Composable
private fun PodiumUserPreview() {
    PodiumUser(
        User(
            "",
            "Davis",
            "Curtis",
            2569,
            R.drawable.flag_fortugal,
            "R.drawable.image_test_media"
        ), 1
    )
}