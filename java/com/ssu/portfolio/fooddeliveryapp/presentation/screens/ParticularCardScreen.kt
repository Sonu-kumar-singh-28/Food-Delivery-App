package com.ssu.portfolio.fooddeliveryapp.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ssu.portfolio.fooddeliveryapp.R
import com.ssu.portfolio.fooddeliveryapp.presentation.utils.BottomSheetToAddProduct

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ParticularCardScreen(navController: NavController) {

    var showBottomSheet by remember { mutableStateOf(false) }

    var firstName by remember { mutableStateOf("Rominus Pizza") }
    var lastName by remember { mutableStateOf("Burger") }
    var rating by remember { mutableStateOf("4.2") }
    var time by remember { mutableStateOf("37 mins") }
    var distance by remember { mutableStateOf("2.6 km") }
    var address by remember { mutableStateOf("Crossing Republic") }
    var uniqueness by remember { mutableStateOf("On Time Preparation") }
    var discount by remember { mutableStateOf("Flat Rs50 OFF on above Rs249") }
    var offers by remember { mutableStateOf("2 offers") }
    var price by remember { mutableStateOf("₹249") }
    var productName by remember { mutableStateOf("Peri Peri Burger") }

    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    Scaffold(
        containerColor = colorResource(R.color.purple_500),
        topBar = {
            TopAppBar(
                title = {},
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White),
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            painter = painterResource(R.drawable.arrowback),
                            contentDescription = null,
                            modifier = Modifier.size(28.dp),
                            tint = Color.Black
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(R.drawable.outline_group_add_24),
                            contentDescription = null,
                            modifier = Modifier.size(28.dp),
                            tint = Color.Black
                        )
                    }
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(R.drawable.outline_bookmark_24),
                            contentDescription = null,
                            modifier = Modifier.size(28.dp),
                            tint = Color.Black
                        )
                    }
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(R.drawable.outline_more_vert_24),
                            contentDescription = null,
                            modifier = Modifier.size(28.dp),
                            tint = Color.Black
                        )
                    }
                },
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .nestedScroll(scrollBehavior.nestedScrollConnection)
                .padding(innerPadding)
        ) {

            item {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .height(220.dp)
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp, vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Column {
                            Text(
                                text = firstName,
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontSize = 25.sp
                            )
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = lastName,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 25.sp
                                )
                                Spacer(modifier = Modifier.width(4.dp))
                                Icon(
                                    painter = painterResource(R.drawable.outline_info_24),
                                    tint = Color.Gray,
                                    contentDescription = null
                                )
                            }
                        }

                        Card(
                            modifier = Modifier.size(width = 55.dp, height = 30.dp),
                            shape = RoundedCornerShape(6.dp),
                            colors = CardDefaults.cardColors(colorResource(R.color.purple_200))
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = rating,
                                    modifier = Modifier.padding(top = 4.dp),
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    color = Color.White
                                )
                                Icon(
                                    painter = painterResource(R.drawable.star),
                                    modifier = Modifier.padding(start = 4.dp).size(16.dp),
                                    tint = Color.White,
                                    contentDescription = null
                                )
                            }
                        }
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp, top = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            painter = painterResource(R.drawable.timer),
                            tint = Color.Green,
                            modifier = Modifier.size(17.dp),
                            contentDescription = null
                        )

                        Text(
                            text = time,
                            fontSize = 14.sp,
                            color = Color.DarkGray,
                            modifier = Modifier.padding(start = 4.dp)
                        )

                        Icon(
                            painter = painterResource(R.drawable.dot),
                            tint = Color.DarkGray,
                            modifier = Modifier.size(16.dp),
                            contentDescription = null
                        )

                        Text(text = distance, fontSize = 14.sp, color = Color.DarkGray)

                        Icon(
                            painter = painterResource(R.drawable.dot),
                            tint = Color.DarkGray,
                            modifier = Modifier.size(16.dp),
                            contentDescription = null
                        )

                        Text(text = address, fontSize = 14.sp, color = Color.DarkGray)

                        Icon(
                            painter = painterResource(R.drawable.down_arrow),
                            tint = Color.DarkGray,
                            modifier = Modifier.padding(start = 2.dp).size(17.dp),
                            contentDescription = null
                        )
                    }

                    Card(
                        modifier = Modifier
                            .padding(start = 8.dp, top = 8.dp)
                            .width(165.dp)
                            .height(28.dp),
                        shape = RoundedCornerShape(12.dp),
                        colors = CardDefaults.cardColors(Color.Gray.copy(alpha = 0.1f))
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.check),
                                modifier = Modifier.padding(start = 8.dp).size(12.dp),
                                tint = colorResource(R.color.purple_500),
                                contentDescription = null
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = uniqueness,
                                color = Color.Gray,
                                fontSize = 14.sp
                            )
                        }
                    }

                    HorizontalDivider(
                        modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 16.dp),
                        color = colorResource(R.color.purple_500),
                        thickness = 1.dp
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            painter = painterResource(R.drawable.discount),
                            modifier = Modifier.padding(start = 16.dp).size(16.dp),
                            tint = Color.Blue,
                            contentDescription = null
                        )

                        Spacer(modifier = Modifier.width(4.dp))

                        Text(
                            text = discount,
                            modifier = Modifier.padding(start = 4.dp),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold
                        )

                        Spacer(modifier = Modifier.weight(1f))

                        Text(
                            text = offers,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Gray
                        )

                        Icon(
                            painter = painterResource(R.drawable.down_arrow),
                            tint = Color.Gray,
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .size(16.dp),
                            contentDescription = null
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .padding(top = 12.dp)
                ) {

                    Text(
                        text = "Recommended for you",
                        modifier = Modifier.padding(horizontal = 12.dp),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    ItemsList(
                        productName = productName,
                        rating = rating,
                        price = price,
                        onClick = { showBottomSheet = true }
                    )

                    HorizontalDivider(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp),
                        thickness = 1.dp,
                        color = colorResource(R.color.purple_200)
                    )

                    ItemsList(
                        productName = productName,
                        rating = rating,
                        price = price,
                        onClick = { showBottomSheet = true }
                    )

                    HorizontalDivider(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp),
                        thickness = 1.dp,
                        color = colorResource(R.color.purple_500)
                    )

                    ItemsList(
                        productName = productName,
                        rating = rating,
                        price = price,
                        onClick = { showBottomSheet = true }
                    )
                }
            }
        }
    }

    if (showBottomSheet) {
        BottomSheetToAddProduct(
            onDismiss = { showBottomSheet = false },
            navController = navController
        )
    }
}

@Composable
fun ItemsList(
    productName: String,
    rating: String,
    price: String,
    onClick: () -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp, horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Column(modifier = Modifier.width(200.dp)) {

            Row(
                modifier = Modifier.padding(start = 2.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Icon(
                    painter = painterResource(R.drawable.veg_icon),
                    modifier = Modifier.size(17.dp),
                    tint = colorResource(R.color.purple_200),
                    contentDescription = null
                )

                Card(
                    modifier = Modifier.padding(start = 8.dp),
                    shape = RoundedCornerShape(5.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = colorResource(R.color.purple_200).copy(alpha = 0.4f)
                    )
                ) {
                    Text(
                        text = "Bestseller",
                        modifier = Modifier.padding(horizontal = 3.dp),
                        color = colorResource(R.color.purple_500),
                        fontSize = 11.sp
                    )
                }
            }

            Text(
                text = productName,
                fontWeight = FontWeight.SemiBold,
                color = colorResource(R.color.purple_500),
                modifier = Modifier.padding(vertical = 8.dp),
                fontSize = 18.sp
            )

            Card(
                modifier = Modifier.size(width = 50.dp, height = 22.dp),
                shape = RoundedCornerShape(6.dp),
                colors = CardDefaults.cardColors(colorResource(R.color.purple_500)),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = rating,
                        modifier = Modifier.padding(start = 3.dp, top = 2.dp),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White
                    )

                    Icon(
                        painter = painterResource(R.drawable.star),
                        modifier = Modifier.size(12.dp),
                        tint = Color.White,
                        contentDescription = null
                    )
                }
            }

            Text(
                text = price,
                modifier = Modifier.padding(vertical = 8.dp),
                color = colorResource(R.color.purple_200),
                fontSize = 16.sp
            )
        }

        Box(
            modifier = Modifier.size(140.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(R.drawable.burger3),
                modifier = Modifier.size(130.dp).clip(RoundedCornerShape(15.dp)),
                contentDescription = null
            )
        }

        Card(
            onClick = onClick,
            modifier = Modifier
                .padding(bottom = 12.dp)
                .size(width = 90.dp, height = 36.dp),
            shape = RoundedCornerShape(5.dp),
            colors = CardDefaults.cardColors(Color.White),
            border = ButtonDefaults.outlinedButtonBorder
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "ADD",
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.purple_700),
                    fontSize = 16.sp
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun ParticularCardScreenPreview() {
    val navController = rememberNavController()
    ParticularCardScreen(navController = navController)
}
