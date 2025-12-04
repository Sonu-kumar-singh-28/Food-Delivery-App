package com.ssu.portfolio.fooddeliveryapp.presentation.utils

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ssu.portfolio.fooddeliveryapp.R
import com.ssu.portfolio.fooddeliveryapp.presentation.navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetToAddProduct(onDismiss: () -> Unit, navController: NavController) {

    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    var text by remember { mutableStateOf("") }
    var count by remember { mutableIntStateOf(1) }

    ModalBottomSheet(
        modifier = Modifier
            .fillMaxWidth()
            .systemBarsPadding(),
        sheetState = sheetState,
        dragHandle = {},
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        onDismissRequest = { onDismiss() }
    ) {
        Scaffold(
            bottomBar = {
                Row(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    // Counter Box
                    Row(
                        modifier = Modifier
                            .border(
                                1.dp,
                                colorResource(R.color.purple_500),
                                RoundedCornerShape(4.dp)
                            )
                            .height(40.dp)
                            .background(Color.White),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        // Minus Button
                        Box(
                            modifier = Modifier
                                .width(40.dp)
                                .fillMaxHeight()
                                .background(colorResource(R.color.purple_500))
                                .clickable {
                                    if (count > 1) count--
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "-",
                                fontSize = 20.sp,
                                color = Color.White
                            )
                        }

                        // Counter Value
                        Box(
                            modifier = Modifier
                                .width(40.dp)
                                .fillMaxHeight(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = count.toString(),
                                fontSize = 16.sp,
                                color = Color.Black
                            )
                        }

                        // Plus Button
                        Box(
                            modifier = Modifier
                                .width(40.dp)
                                .fillMaxHeight()
                                .background(colorResource(R.color.purple_500))
                                .clickable { count++ },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "+",
                                fontSize = 20.sp,
                                color = Color.White
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    // Add item Button
                    Button(
                        onClick = {
                            navController.navigate(Routes.FinalCheckoutScreen)
                        },
                        modifier = Modifier
                            .height(40.dp)
                            .weight(1f),
                        colors = ButtonDefaults.buttonColors(colorResource(R.color.purple_500)),
                        shape = RoundedCornerShape(4.dp)
                    ) {
                        Text(
                            text = "Add item ₹249",
                            color = Color.White,
                            fontSize = 16.sp
                        )
                    }
                }
            }
        ) {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxWidth()
                    .background(Color.Transparent)
            ) {

                // PRODUCT CARD
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                    ) {

                        // Product Image
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(280.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.brick_oven_pizza),
                                contentDescription = "Pizza",
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(12.dp)
                                    .clip(RoundedCornerShape(16.dp)),
                                contentScale = ContentScale.Crop
                            )

                            // Top Row (Veg + Bestseller)
                            Row(
                                modifier = Modifier
                                    .padding(16.dp)
                                    .align(Alignment.TopStart),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    painter = painterResource(id = R.drawable.veg_icon),
                                    contentDescription = "veg",
                                    modifier = Modifier.size(18.dp),
                                    tint = Color.Unspecified
                                )

                                Spacer(modifier = Modifier.width(8.dp))

                                Box(
                                    modifier = Modifier
                                        .background(
                                            color = Color(0xFFF9F0E6),
                                            shape = RoundedCornerShape(4.dp)
                                        )
                                        .padding(horizontal = 4.dp, vertical = 2.dp)
                                ) {
                                    Text(
                                        text = "Bestseller",
                                        color = Color(0xFFE67E22),
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Medium
                                    )
                                }
                            }

                            // Share + Bookmark
                            Row(
                                modifier = Modifier
                                    .padding(12.dp)
                                    .align(Alignment.TopEnd),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.Share,
                                    contentDescription = "Share",
                                    tint = Color.White,
                                    modifier = Modifier.padding(end = 8.dp)
                                )
                                Icon(
                                    painter = painterResource(R.drawable.outline_bookmark_24),
                                    contentDescription = "Bookmark",
                                    tint = Color.White
                                )
                            }
                        }

                        // Product Title + Rating
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = "Brick Oven Pizza",
                                fontSize = 22.sp,
                                color = Color.Black,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            // Rating
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                repeat(5) { index ->
                                    Icon(
                                        imageVector = Icons.Filled.Star,
                                        contentDescription = null,
                                        tint = Color(0xFFFFC107),
                                        modifier = Modifier.size(18.dp)
                                    )
                                }

                                Spacer(modifier = Modifier.width(4.dp))

                                Text(
                                    text = "(211)",
                                    color = Color.Gray,
                                    fontSize = 12.sp
                                )
                            }

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = "[Chef's Special]",
                                color = Color.Gray,
                                fontSize = 14.sp
                            )
                        }
                    }
                }

                // COOKING REQUEST CARD
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(1.dp, Color(0xFFE0E0E0)),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Text(
                                text = "Add a cooking request (optional)",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color(0xFF424242)
                            )

                            Icon(
                                imageVector = Icons.Outlined.Info,
                                contentDescription = "Info",
                                tint = Color(0xFFBDBDBD),
                                modifier = Modifier.size(20.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(18.dp))

                        TextField(
                            value = text,
                            onValueChange = { text = it },
                            placeholder = {
                                Text(
                                    text = "e.g. Don't make it too spicy",
                                    color = Color(0xFFBDBDBD),
                                    fontSize = 14.sp
                                )
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(150.dp),
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color(0xFFF5F5F5),
                                unfocusedContainerColor = Color(0xFFF5F5F5),
                                disabledContainerColor = Color(0xFFF5F5F5),
                                unfocusedIndicatorColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                disabledIndicatorColor = Color.Transparent
                            ),
                            shape = RoundedCornerShape(8.dp)
                        )
                    }
                }
            }
        }
    }
}
