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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.profs.queezy.R
import com.profs.queezy.data.utils.Destinations
import com.profs.queezy.presentation.theme.Accent3
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