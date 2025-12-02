package com.ssu.portfolio.fooddeliveryapp.presentation.components

import android.provider.CalendarContract
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material.Card
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ssu.portfolio.fooddeliveryapp.R
import okhttp3.internal.wait


@Composable
fun DiningScreenContent(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White)
        .padding(0.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {

        Spacer(modifier = Modifier.height(20.dp))

        // All Function Are Called in  There
        TextOfExploreImage()

        ExploreImage()

        TextAbove()

        Spacer(modifier = Modifier.height(8.dp))

        CarnivalCard()

        Spacer(modifier = Modifier.height(8.dp))

        TextBelow()

        Spacer(modifier = Modifier.height(8.dp))

        MatchCard()

        Spacer(modifier = Modifier.height(20.dp))


    }
}

@Composable
fun TextOfExploreImage(){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 16.dp)
    ) {
        Box(
            modifier = Modifier.weight(1f)
                .height(1.dp)
                .background(Color.LightGray)
        )
        Text(
            text = "EXPLORE",
            style = TextStyle(
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight.Light,
                letterSpacing = 2.sp
            ),
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp),
            textAlign = TextAlign.Center
        )

        Box(
            modifier = Modifier
                .weight(1f)
                .height(1.dp)
                .background(Color.LightGray)
        )
    }
}


@Composable
fun ExploreImage(){

    Image(
        painter = painterResource(R.drawable.exploree),
        contentDescription = "image",
        modifier = Modifier.fillMaxWidth().size(300.dp)
    )
}


@Composable
fun TextAbove(){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .height(1.dp)
                .background(color = Color.LightGray)
        )

        Text(
            text = "OFFERS CURATED FOR YOU",
            style = TextStyle(
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight.Light,
                letterSpacing = 2.sp,
            ),
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp),
            textAlign = TextAlign.Center
        )

        Box(
            modifier = Modifier
                .weight(1f)
                .height(1.dp)
                .background(Color.LightGray)
        )
    }
}



@Composable

fun TextBelow(){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
    ) {
        Box(modifier = Modifier
            .weight(1f)
            .height(1.dp)
            .background(Color.LightGray)
        )

        Text(
            text = "DINNING SPECIALS",
            style = TextStyle(
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight.Light,
                letterSpacing = 2.sp
            ),
            modifier = Modifier.padding(vertical = 8.dp , horizontal = 8.dp),
            textAlign = TextAlign.Center
        )

        Box(
            modifier = Modifier
                .weight(1f)
                .height(1.dp)
                .background(Color.LightGray)
        )
    }
}


@Composable
fun CarnivalCard(){

    Column(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        verticalArrangement = Arrangement.Center) {

        Card(
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(15.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ), elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            )
        ) {

            Box(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(id = R.drawable.diningcarnival),
                    contentDescription = "Restaurants near me",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}


@Composable
fun MatchCard(){
    Column(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .height(135.dp)
                .padding(0.dp),
            shape = RoundedCornerShape(15.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 8.dp
            ),
        ) {
            Box(
                modifier = Modifier.fillMaxSize()){
                Image(
                    painter = painterResource(R.drawable.match),
                    contentDescription = "Restaurants near me",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}




@Composable
@Preview(showBackground = true)
fun  ShowFunction(){
    DiningScreenContent()
}
