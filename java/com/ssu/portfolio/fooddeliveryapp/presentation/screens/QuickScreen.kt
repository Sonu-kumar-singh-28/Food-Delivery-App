package com.ssu.portfolio.fooddeliveryapp.presentation.screens

import androidx.annotation.ColorRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ssu.portfolio.fooddeliveryapp.R
import com.ssu.portfolio.fooddeliveryapp.presentation.components.HomeScreenCards
import com.ssu.portfolio.fooddeliveryapp.presentation.screens.dining.TopAppBarDiningScreen
import com.ssu.portfolio.fooddeliveryapp.presentation.utils.BottomSheetToAddProduct

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuickScreen(navController: NavController, listState: LazyListState) {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    var showBottomSheet by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBarDiningScreen(scrollBehavior, navController)
        }
    ) { innerPadding ->
        LazyColumn(
            contentPadding = PaddingValues(vertical = 0.dp),
            state = listState,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(bottom = innerPadding.calculateBottomPadding())
                .nestedScroll(scrollBehavior.nestedScrollConnection)
        ) {
            item {
                Box(modifier = Modifier.fillMaxWidth()) {
                    Image(
                        painter = painterResource(R.drawable.quickbanner),
                        contentDescription = "Quick Screen",
                        modifier = Modifier
                            .fillMaxSize()
                            .clip(RoundedCornerShape(bottomStart = 15.dp, bottomEnd = 15.dp))
                    )
                }
            }

            item {
                LazyRow(modifier = Modifier.fillMaxWidth()) {
                    items(1) {
                        QuickScreenComponents(navController) { showBottomSheet = true }
                    }
                }
            }

            items(5) {
                Spacer(Modifier.height(16.dp))
                HomeScreenCards(navController)
                Spacer(Modifier.height(16.dp))
            }
        }

        if (showBottomSheet) {
            BottomSheetToAddProduct(
                onDismiss = { showBottomSheet = false },
                navController = navController
            )
        }
    }
}

@Composable
fun QuickScreenComponents(navController: NavController, onAddClick: () -> Unit) {
    var productName by remember { mutableStateOf("Peri Peri Burger") }
    var rating by remember { mutableStateOf("4.2") }
    var price by remember { mutableStateOf("₹249") }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 16.dp),
        colors = CardDefaults.cardColors(Color.White)
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
                    modifier = Modifier
                        .wrapContentSize()
                        .padding(start = 2.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(R.drawable.veg_icon),
                        contentDescription = null,
                        tint = colorResource(R.color.purple_500),
                        modifier = Modifier.size(17.dp)
                    )
                }

                Card(
                    modifier = Modifier.padding(start = 8.dp),
                    shape = RoundedCornerShape(5.dp),
                    colors = CardDefaults.cardColors(colorResource(R.color.purple_200))
                ) {
                    Text(
                        text = "Bestseller",
                        modifier = Modifier.padding(horizontal = 3.dp),
                        color = colorResource(R.color.purple_700),
                        fontSize = 11.sp
                    )
                }

                Text(
                    text = productName,
                    fontWeight = FontWeight.SemiBold,
                    color = colorResource(R.color.purple_700),
                    modifier = Modifier
                        .padding(horizontal = 1.dp, vertical = 8.dp),
                    fontSize = 18.sp
                )

                Card(
                    modifier = Modifier.size(width = 50.dp, height = 22.dp),
                    shape = RoundedCornerShape(6.dp),
                    colors = CardDefaults.cardColors(colorResource(R.color.purple_500))
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
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier
                                .padding(start = 3.dp, top = 2.dp, end = 3.dp)
                                .size(12.dp)
                        )
                    }
                }

                Text(
                    text = price,
                    modifier = Modifier.padding(horizontal = 1.dp, vertical = 8.dp),
                    color = colorResource(R.color.purple_200),
                    fontSize = 16.sp
                )
            }

            Box(
                modifier = Modifier.size(160.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.burger3),
                    contentDescription = "Product Image",
                    modifier = Modifier
                        .size(130.dp)
                        .clip(RoundedCornerShape(15.dp)),
                    alignment = Alignment.Center
                )
            }

            Button(
                onClick = onAddClick,
                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .padding(top = 120.dp)
                    .size(width = 100.dp, height = 36.dp),
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.purple_200)),
                contentPadding = PaddingValues(0.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.baseline_add_24),
                    contentDescription = "Add item",
                    tint = Color.Red,
                    modifier = Modifier.size(14.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuickScreenPreview() {
    val mockNavController = remember { object : NavController(null!!) {} }
    val listState = rememberLazyListState()
    QuickScreen(navController = mockNavController, listState = listState)
}