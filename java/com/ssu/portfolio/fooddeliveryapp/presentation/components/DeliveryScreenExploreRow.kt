package com.ssu.portfolio.fooddeliveryapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ssu.portfolio.fooddeliveryapp.R

@Composable
fun ExploreRow() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .background(color = Color.White)
    ) {

        Text(
            text = "Explore Row",
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 16.dp),
            fontSize = 16.sp,
            color = Color.Gray
        )

        LazyRow(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            item {
                ExploreCards(
                    drawable = R.drawable.price_tag,
                    name = "Offers"
                )
                Spacer(modifier = Modifier.width(12.dp))

                ExploreCards(
                    drawable = R.drawable.snack_meal,
                    name = "Plan Party"
                )
                Spacer(modifier = Modifier.width(12.dp))

                ExploreCards(
                    drawable = R.drawable.collections,
                    name = "Collections"
                )
                Spacer(modifier = Modifier.width(12.dp))

                ExploreCards(
                    drawable = R.drawable.fruits,
                    name = "Healthy"
                )
                Spacer(modifier = Modifier.width(12.dp))
            }
        }
    }
}

@Composable
fun ExploreCards(
    drawable: Int,
    name: String
) {
    Card(
        modifier = Modifier.size(90.dp, 110.dp),
        elevation = CardDefaults.cardElevation(1.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Icon(
                painter = painterResource(drawable),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier.size(50.dp)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = name,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun  ExploreRowPreview(){
    ExploreRow()
}