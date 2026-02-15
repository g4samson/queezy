package com.profs.queezy.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.profs.queezy.R
import com.profs.queezy.data.utils.Destinations
import com.profs.queezy.presentation.theme.NeutralBlack
import com.profs.queezy.presentation.theme.NeutralGrey3

@Composable
fun BottomBar(selected: String = "", navController: NavHostController) {

    Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.BottomCenter) {
        Image(
            painterResource(R.drawable.background_bottom),
            null,
            Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )

        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 26.dp)
                .padding(bottom = 38.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                Modifier.fillMaxWidth(0.5f),
                horizontalArrangement = Arrangement.Start
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(0.6f),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(
                        onClick = { if (selected != "home") navController.navigate(Destinations.Home) },
                        modifier = Modifier.size(24.dp)
                    ) {
                        Icon(
                            painterResource(if (selected == "home") R.drawable.icon_bottom_home_selected else R.drawable.icon_bottom_home),
                            null,
                            Modifier, if (selected == "home") NeutralBlack else NeutralGrey3
                        )
                    }

                    IconButton(onClick = {
                        navController.navigate(Destinations.Discover)
                    }, modifier = Modifier.size(24.dp)) {
                        Icon(
                            painterResource(R.drawable.icon_bottom_discover),
                            null,
                            Modifier, NeutralGrey3
                        )
                    }
                }
            }

            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(0.6f),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = {
                        navController.navigate(Destinations.Leaderboard)
                    }, modifier = Modifier.size(24.dp)) {
                        Icon(
                            painterResource(R.drawable.icon_bottom_leaderboard),
                            null,
                            Modifier, NeutralGrey3
                        )
                    }

                    IconButton(onClick = {
                        if (selected != "profile") navController.navigate(Destinations.Profile)
                    }, modifier = Modifier.size(24.dp)) {
                        Icon(
                            painterResource(if (selected == "profile") R.drawable.icon_bottom_profile_selected else R.drawable.icon_bottom_profile),
                            null,
                            Modifier, if (selected == "profile") NeutralBlack else NeutralGrey3
                        )
                    }
                }
            }
        }

        Box(
            Modifier
                .fillMaxWidth()
                .padding(bottom = 59.dp), contentAlignment = Alignment.BottomCenter
        ) {
            IconButton(onClick = {}, modifier = Modifier.size(48.dp)) {
                Icon(
                    painterResource(R.drawable.icon_bottom_post),
                    null,
                    Modifier,
                    Color.Unspecified
                )
            }
        }
    }
}

@Preview
@Composable
private fun BottomBarPreview() {
    BottomBar("home", rememberNavController())
}