package com.ssu.portfolio.fooddeliveryapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ssu.portfolio.fooddeliveryapp.R

// ---------------- SEARCH BAR -----------------

@Composable
fun DeliveryScreenSearchBar(navController: NavController) {
    var query by remember { mutableStateOf("") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .shadow(2.dp, RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .border(1.dp, Color.Gray, RoundedCornerShape(16.dp))
            .padding(horizontal = 16.dp)
            .clickable {
                // To navigate

            },
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            imageVector = Icons.Default.Search,
            tint = colorResource(android.R.color.holo_purple),
            contentDescription = "search_icon",
            modifier = Modifier.size(20.dp)
        )

        Spacer(modifier = Modifier.width(10.dp))

        BasicTextField(
            value = query,
            onValueChange = { query = it },
            textStyle = TextStyle(fontSize = 16.sp, color = Color.Black),
            singleLine = true,
            modifier = Modifier.weight(1f),
            decorationBox = { innerTextField ->
                if (query.isEmpty()) {
                    Text(
                        "Restaurant name or a dish…",
                        fontSize = 15.sp,
                        color = Color.Gray
                    )
                }
                innerTextField()
            }
        )

        Spacer(modifier = Modifier.width(8.dp))

        Icon(
            painter = painterResource(R.drawable.mic),
            contentDescription = "voice_search",
            tint = colorResource(R.color.purple_500),
            modifier = Modifier.size(22.dp)
        )
    }
}


// ---------------- VEG MODE TOGGLE -----------------

@Composable
fun VegModeToggle(isChecked: Boolean, onCheckedChange: (Boolean) -> Unit) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
    ) {
        Text(
            text = "VEG",
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            color = Color.Black
        )

        Text(
            text = "MODE",
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            color = Color.Black
        )

        CustomSwitch(isChecked, onCheckedChange)
    }
}

@Composable
fun CustomSwitch(isChecked: Boolean, onCheckedChange: (Boolean) -> Unit) {

    Box(
        modifier = Modifier
            .size(width = 36.dp, height = 20.dp)
            .clip(RoundedCornerShape(50))
            .background(if (isChecked) Color(0xFF008000) else Color.LightGray)
            .clickable { onCheckedChange(!isChecked) },
        contentAlignment = Alignment.CenterStart
    ) {

        Box(
            modifier = Modifier
                .size(16.dp)
                .offset(x = if (isChecked) 16.dp else 2.dp)
                .clip(CircleShape)
                .shadow(4.dp)
                .background(Color.White)
        )
    }
}


// ---------------- PREVIEW -----------------

@Preview(showBackground = true)
@Composable
private fun ShowPreview() {
    var isChecked by remember { mutableStateOf(false) }
    VegModeToggle(isChecked = isChecked, onCheckedChange = { isChecked = it })
}
