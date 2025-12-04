package com.ssu.portfolio.fooddeliveryapp.presentation.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ssu.portfolio.fooddeliveryapp.R
import com.ssu.portfolio.fooddeliveryapp.presentation.utils.OrderPlacedDialog

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FinalCheckoutScreen(navController: NavController) {

    var showOrderDialog by remember { mutableStateOf(false) }

    var name by remember { mutableStateOf("Rominus Pizza And Burger") }
    var time by remember { mutableStateOf("37 mins") }
    var productName by remember { mutableStateOf("Peri Peri Burger") }
    var price by remember { mutableStateOf("₹249") }
    var newPrice by remember { mutableStateOf("₹268") }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(WindowInsets.navigationBars.asPaddingValues()),
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(text = name, fontSize = 13.sp, color = Color.DarkGray)
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Time to Home",
                                color = Color.Gray,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            VerticalDivider(
                                modifier = Modifier
                                    .padding(horizontal = 4.dp)
                                    .padding(top = 10.dp, bottom = 12.dp)
                            )
                            Text(
                                text = "256, Shanti Nagar, Ghaziabad..",
                                fontSize = 12.sp,
                                color = Color.DarkGray
                            )
                            Icon(
                                painter = painterResource(R.drawable.down_arrow),
                                modifier = Modifier
                                    .padding(horizontal = 3.dp)
                                    .size(14.dp),
                                tint = Color.DarkGray,
                                contentDescription = null
                            )
                        }
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            painter = painterResource(R.drawable.arrowback),
                            tint = Color.DarkGray,
                            modifier = Modifier.size(22.dp),
                            contentDescription = null
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            painter = painterResource(R.drawable.share),
                            modifier = Modifier.size(18.dp),
                            tint = Color.DarkGray,
                            contentDescription = null
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )
        },
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Button(
                    onClick = { showOrderDialog = true },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.purple_500)),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "Place Order",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.align(Alignment.Center)
                        )
                        Icon(
                            painter = painterResource(R.drawable.baseline_arrow_right_24),
                            contentDescription = null,
                            modifier = Modifier
                                .align(Alignment.CenterEnd)
                                .size(35.dp)
                        )
                    }
                }
            }

            if (showOrderDialog) {
                OrderPlacedDialog(
                    onDismiss = { showOrderDialog = false },
                    onConfirm = { showOrderDialog = false }
                )
            }
        }
    ) { innerPadding ->
        LazyColumn(
            contentPadding = PaddingValues(vertical = 0.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            item {
                ProductCard(productName = productName, price = price)
                CouponCard()
                Spacer(modifier = Modifier.height(16.dp))
                AddressAndBillCard(time = time, newPrice = newPrice)

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 16.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.White)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.donationbanner),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize()
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "CANCELLATION POLICY",
                        modifier = Modifier.padding(horizontal = 4.dp),
                        color = Color.DarkGray
                    )
                    Text(
                        text = "Help us reduce food waste by avoiding cancellations. The amount paid is non-refundable after placement.",
                        modifier = Modifier.padding(horizontal = 4.dp),
                        fontSize = 12.sp,
                        lineHeight = 14.sp,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}

@Composable
fun ProductCard(productName: String, price: String) {

    var quantity by remember { mutableStateOf(1) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 16.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Column {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(colorResource(R.color.purple_200))
                    .padding(8.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.goldicon1),
                    tint = Color.Unspecified,
                    modifier = Modifier.size(28.dp),
                    contentDescription = null
                )

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 12.dp)
                ) {
                    Text(
                        text = "Get Gold for 3 months",
                        color = Color.DarkGray,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "Unlimited free deliveries & more benefits",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Learn more",
                            fontSize = 14.sp,
                            color = Color.DarkGray
                        )
                        Icon(
                            painter = painterResource(R.drawable.baseline_arrow_right_24),
                            tint = colorResource(R.color.purple_200),
                            contentDescription = null
                        )
                    }
                }

                Column(horizontalAlignment = Alignment.End) {
                    OutlinedButton(
                        onClick = {},
                        modifier = Modifier.height(32.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            contentColor = colorResource(R.color.purple_500)
                        ),
                        border = BorderStroke(1.dp, colorResource(R.color.purple_500))
                    ) {
                        Text("ADD")
                    }
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "₹30",
                        color = Color.Black,
                        fontSize = 14.sp,
                    )
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(R.drawable.veg_icon),
                    tint = Color.Unspecified,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )

                Column(
                    modifier = Modifier.padding(horizontal = 12.dp)
                ) {
                    Text(
                        text = productName,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Text(
                        text = price,
                        fontSize = 14.sp,
                        color = Color.DarkGray
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Column(horizontalAlignment = Alignment.End) {
                    Card(
                        modifier = Modifier.size(75.dp, 26.dp),
                        colors = CardDefaults.cardColors(colorResource(R.color.purple_200)),
                        border = BorderStroke(1.dp, colorResource(R.color.purple_200)),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.outline_check_indeterminate_small_24),
                                tint = colorResource(R.color.purple_500),
                                modifier = Modifier
                                    .padding(2.dp)
                                    .clickable { if (quantity > 1) quantity-- },
                                contentDescription = null
                            )
                            Text(
                                text = quantity.toString(),
                                color = Color.Black,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Icon(
                                painter = painterResource(R.drawable.baseline_add_24),
                                tint = colorResource(R.color.purple_500),
                                modifier = Modifier
                                    .padding(2.dp)
                                    .size(18.dp)
                                    .clickable { quantity++ },
                                contentDescription = null
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = null,
                            tint = Color(0xFFE91E63),
                            modifier = Modifier.size(18.dp)
                        )
                        Text(
                            text = "Add items",
                            color = colorResource(R.color.purple_500),
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }

                    HorizontalDivider(
                        modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp),
                        color = colorResource(R.color.purple_200)
                    )

                    LazyRow {
                        item {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 16.dp, vertical = 8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                OutlinedButton(
                                    onClick = { },
                                    shape = RoundedCornerShape(8.dp),
                                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black),
                                    border = BorderStroke(1.dp, Color.LightGray),
                                    modifier = Modifier.padding(end = 8.dp)
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.cutlery),
                                        contentDescription = null,
                                        tint = Color.Black,
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Text(
                                        text = "Don't send cutlery",
                                        fontSize = 14.sp,
                                        modifier = Modifier.padding(start = 4.dp)
                                    )
                                }

                                OutlinedButton(
                                    onClick = { },
                                    shape = RoundedCornerShape(8.dp),
                                    colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black),
                                    border = BorderStroke(1.dp, Color.LightGray)
                                ) {
                                    Icon(
                                        painter = painterResource(R.drawable.notes),
                                        contentDescription = null,
                                        tint = Color.Black,
                                        modifier = Modifier.size(16.dp)
                                    )
                                    Text(
                                        text = "Add a note for the restaura",
                                        fontSize = 14.sp,
                                        modifier = Modifier.padding(start = 4.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CouponCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(24.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(R.drawable.coupons),
                    contentDescription = null,
                    tint = Color.DarkGray,
                    modifier = Modifier.size(18.dp)
                )
                Text(
                    text = "View all coupons",
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }

            Icon(
                painter = painterResource(R.drawable.arrowright),
                contentDescription = null,
                tint = Color.Gray,
                modifier = Modifier.size(18.dp)
            )
        }
    }
}

@Composable
fun AddressAndBillCard(time: String, newPrice: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 8.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.timer),
                contentDescription = null,
                tint = colorResource(R.color.purple_200),
                modifier = Modifier.size(16.dp)
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
            ) {
                Text(
                    text = "Delivery in $time",
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.height(6.dp))
                Text(
                    text = "Want this Later? Schedule it",
                    fontSize = 14.sp,
                    color = Color.DarkGray,
                    textDecoration = TextDecoration.Underline
                )
            }
        }

        HorizontalDivider(modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                Icon(
                    imageVector = Icons.Outlined.Home,
                    contentDescription = null,
                    tint = Color.DarkGray,
                    modifier = Modifier.size(18.dp)
                )

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 6.dp)
                ) {
                    Text(
                        text = "Delivery at Home",
                        fontSize = 14.sp,
                        color = Color.DarkGray,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "265, Shanti Nagar, Ghaziabad...",
                        fontSize = 12.sp,
                        color = Color.Gray
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "Add instructions for delivery partner",
                        fontSize = 14.sp,
                        color = Color.DarkGray,
                        textDecoration = TextDecoration.Underline
                    )
                }
            }

            Icon(
                painter = painterResource(R.drawable.arrowright),
                contentDescription = null,
                tint = Color.Gray,
                modifier = Modifier.size(18.dp)
            )
        }
    }

    HorizontalDivider(modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp))

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Outlined.Phone,
                contentDescription = null,
                tint = Color.DarkGray,
                modifier = Modifier.size(18.dp)
            )
        }

        Text(
            text = "Himanshu Gaur,",
            fontSize = 14.sp,
            color = Color.DarkGray,
            modifier = Modifier.padding(start = 8.dp)
        )

        Text(
            text = "+91-8872551231",
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(start = 8.dp)
        )
    }

    Icon(
        painter = painterResource(R.drawable.arrowright),
        contentDescription = null,
        tint = Color.Gray,
        modifier = Modifier.size(18.dp)
    )

    HorizontalDivider(modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp))

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Row {
                Icon(
                    painter = painterResource(R.drawable.notes),
                    contentDescription = null,
                    tint = Color.DarkGray,
                    modifier = Modifier.size(18.dp)
                )
            }

            Text(
                text = "Total Bill $newPrice",
                fontSize = 14.sp,
                color = Color.DarkGray,
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        Text(
            text = "Incl. taxes and charges",
            fontSize = 12.sp,
            color = Color.Gray,
            modifier = Modifier.padding(start = 20.dp)
        )
    }

    Icon(
        painter = painterResource(R.drawable.arrowright),
        contentDescription = null,
        tint = Color.Gray,
        modifier = Modifier.size(18.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun FinalCheckoutScreenPreview() {
    FinalCheckoutScreen(navController = NavController(LocalContext.current))
}
