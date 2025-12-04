package com.ssu.portfolio.fooddeliveryapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.ssu.portfolio.fooddeliveryapp.R


@Composable
fun HomeScreenCards(navController: NavController) {

    Card(
        onClick = {
           // navController.navigate(Routes.particularCardScreen)
        },
        shape = RoundedCornerShape(22.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(312.dp)
            .padding(horizontal = 16.dp)
    ) {

        Box(modifier = Modifier.fillMaxSize()) {

            val pager = rememberPagerState(
                initialPage = 0,
                pageCount = { 4 }
            )

            CardImageRow(pagerState = pager)

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, start = 12.dp, end = 12.dp),
                horizontalArrangement = Arrangement.Center
            ) {

                when (pager.currentPage) {
                    0 -> PriceCard("Veg - Biryani", "₹240")
                    1 -> PriceCard("Bricks Oven Pizza", "₹259")
                    2 -> PriceCard("Spring Roll", "₹160")
                    3 -> PriceCard("Noodles", "₹130")
                }

                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource(R.drawable.baseline_bookmark_24),
                        modifier = Modifier.size(34.dp),
                        tint = Color.Black.copy(alpha = 0.6f),
                        contentDescription = "Bookmark"
                    )
                }
            }

            pageCount(pagerState = pager)

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 192.dp)
                    .height(120.dp)
            ) {
                SmallDetailedCard()
                DetailCard()
            }
        }
    }
}

@Composable
fun CardImageRow(pagerState: androidx.compose.foundation.pager.PagerState) {

    HorizontalPager(state = pagerState) { page ->

        when (page) {
            0 -> AsyncImage(R.drawable.veg_biryani, null, Modifier.fillMaxWidth())
            1 -> AsyncImage(R.drawable.brick_oven_pizza, null, Modifier.fillMaxWidth())
            2 -> AsyncImage(R.drawable.spring_roll, null, Modifier.fillMaxWidth())
            3 -> AsyncImage(R.drawable.chowmein1, null, Modifier.fillMaxWidth())
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun pageCount(pagerState: androidx.compose.foundation.pager.PagerState) {
    Row(
        modifier = Modifier.padding(start = 250.dp, top = 196.dp),
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(pagerState.pageCount) {
            Spacer(
                modifier = Modifier
                    .size(9.dp)
                    .background(
                        color = if (pagerState.currentPage == it)
                            Color.White
                        else Color.White.copy(alpha = 0.5f),
                        shape = CircleShape
                    )
            )
        }
    }
}

@Composable
fun DetailCard() {

    val restaurantName = remember { mutableStateOf("Haldiram's") }
    val rating = remember { mutableStateOf("4.2") }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(bottomStart = 22.dp, bottomEnd = 22.dp)
    ) {

        Column(Modifier.fillMaxSize()) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = restaurantName.value,
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Card(
                    modifier = Modifier.size(45.dp, 22.dp),
                    colors = CardDefaults.cardColors(colorResource(R.color.purple_500)),
                    shape = RoundedCornerShape(6.dp)
                ) {
                    Row(
                        Modifier.fillMaxSize(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            rating.value,
                            Modifier.padding(start = 4.dp),
                            fontSize = 12.sp,
                            color = Color.White
                        )
                        Icon(
                            painter = painterResource(R.drawable.star),
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier.size(10.dp)
                                .padding(start = 4.dp)
                        )
                    }
                }
            }

            Card(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .size(165.dp, 22.dp),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(Color.Gray.copy(alpha = 0.2f))
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {

                    Icon(
                        painterResource(R.drawable.check),
                        contentDescription = null,
                        tint = colorResource(R.color.purple_500),
                        modifier = Modifier.padding(start = 8.dp).size(12.dp)
                    )

                    Spacer(Modifier.width(4.dp))

                    Text(
                        text = "On Time Preparation",
                        color = Color.Gray,
                        fontSize = 12.sp
                    )
                }
            }

            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp),
                color = colorResource(R.color.purple_200),
                thickness = 1.dp
            )

            Row(Modifier.fillMaxWidth()) {

                Icon(
                    painterResource(R.drawable.discount),
                    contentDescription = null,
                    tint = Color.Blue,
                    modifier = Modifier.padding(start = 16.dp).size(16.dp)
                )

                Spacer(Modifier.width(6.dp))

                Text(
                    text = "Flat ₹50 off above ₹249",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Composable
fun SmallDetailedCard() {

    val time = remember { mutableStateOf("44 mins") }
    val distance = remember { mutableStateOf("1.6 km") }

    Card(
        modifier = Modifier.size(122.dp, 25.dp),
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(topEnd = 12.dp)
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 6.dp)
        ) {

            Icon(
                painter = painterResource(R.drawable.timer),
                contentDescription = null,
                tint = Color.Green,
                modifier = Modifier.size(12.dp)
            )

            Spacer(Modifier.width(4.dp))

            Text(time.value, fontSize = 11.sp, color = Color.Gray)

            Spacer(Modifier.width(6.dp))

            Icon(
                painter = painterResource(R.drawable.dot),
                contentDescription = null,
                tint = Color.Gray,
                modifier = Modifier.size(12.dp)
            )

            Spacer(Modifier.width(4.dp))

            Text(distance.value, fontSize = 11.sp, color = Color.Gray)
        }
    }
}

@Composable
fun PriceCard(name: String, price: String) {

    Card(
        modifier = Modifier
            .padding(top = 12.dp)
            .size(160.dp, 21.dp)
            .clickable {},
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(Color.Black.copy(alpha = 0.5f))
    ) {

        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(name, color = Color.White, fontSize = 12.sp)

            Icon(
                painter = painterResource(R.drawable.dot),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )

            Text(price, color = Color.White, fontSize = 12.sp)
        }
    }
}
