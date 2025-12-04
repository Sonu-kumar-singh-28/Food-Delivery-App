package com.ssu.portfolio.fooddeliveryapp.presentation.screens.dining

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ssu.portfolio.fooddeliveryapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarDiningScreen(
    scrollBehavior: TopAppBarScrollBehavior,
    navController: NavController
) {
    val collapsedFraction = scrollBehavior.state.collapsedFraction

    // Content fades from White → Transparent → Black depending on scroll
    val contentColor = lerp(
        Color.White,
        Color.Transparent,
        collapsedFraction
    )

    // Text/Icon fade animation
    val contentAlpha = 1f - collapsedFraction

    TopAppBar(
        title = {
            Column(modifier = Modifier.alpha(contentAlpha)) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(22.dp)
                ) {
                    Text(
                        text = "Home",
                        color = contentColor,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Icon(
                        painter = painterResource(R.drawable.down_arrow),
                        modifier = Modifier
                            .size(30.dp)
                            .padding(top = 6.dp),
                        tint = contentColor,
                        contentDescription = "Down Arrow"
                    )
                }

                Text(
                    text = "565, Shiv Vihar, Bahraumpur, Shanti Nagar",
                    fontWeight = FontWeight.SemiBold,
                    color = contentColor,
                    fontSize = 15.sp
                )
            }
        },

        // Navigation Icon
        navigationIcon = {
            Icon(
                painter = painterResource(R.drawable.locationdiningscreen),
                modifier = Modifier.size(30.dp),
                tint = contentColor,
                contentDescription = "Location"
            )
        },

        // Actions (Profile Button)
        actions = {
            IconButton(onClick = {
                //navController.navigate(Routes.ProfileScreen)
            }) {
                Icon(
                    painter = painterResource(R.drawable.profile),
                    tint = contentColor,
                    contentDescription = "Profile"
                )
            }
        },

        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent
        ),

        scrollBehavior = scrollBehavior,
        modifier = Modifier.fillMaxWidth()
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun PreviewTopAppBarDiningScreen() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    // Fake NavController for Preview
    val navController = rememberNavController()

    TopAppBarDiningScreen(
        scrollBehavior = scrollBehavior,
        navController = navController
    )
}
