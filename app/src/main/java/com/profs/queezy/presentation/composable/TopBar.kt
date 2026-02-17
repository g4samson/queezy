package com.profs.queezy.presentation.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.profs.queezy.R
import com.profs.queezy.presentation.theme.NeutralWhite
import com.profs.queezy.presentation.theme.Typography

@Composable
fun TopBar(title: String = "", settings: Boolean = false, navController: NavHostController) {

    Row(
        Modifier.fillMaxWidth(),
        Arrangement.SpaceBetween,
        Alignment.CenterVertically
    ) {
        IconButton(onClick = { navController.navigateUp() }) {
            Icon(painterResource(R.drawable.icon_back), null, Modifier.size(24.dp), NeutralWhite)
        }

        Text(title, style = Typography.titleLarge)

        IconButton(onClick = {}, enabled = settings) {
            Icon(
                painterResource(R.drawable.icon_settings),
                null,
                Modifier.size(24.dp),
                if (settings) NeutralWhite else Color.Transparent
            )
        }
    }

}

@Preview
@Composable
private fun TopBar1Preview() {
    TopBar("Discover", false, rememberNavController())
}

@Preview
@Composable
private fun TopBar2Preview() {
    TopBar("", true, rememberNavController())
}