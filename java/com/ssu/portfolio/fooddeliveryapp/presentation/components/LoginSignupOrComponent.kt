package com.ssu.portfolio.fooddeliveryapp.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
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
import com.ssu.portfolio.fooddeliveryapp.R

@Composable
fun OrComponent() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // -------- OR Row --------
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            HorizontalDivider(
                modifier = Modifier.weight(1f),
                color = Color.LightGray,
                thickness = 0.8.dp
            )

            Text(
                text = "or",
                modifier = Modifier.padding(horizontal = 8.dp)
            )

            HorizontalDivider(
                modifier = Modifier.weight(1f),
                color = Color.LightGray,
                thickness = 0.8.dp
            )
        }

        //  SPACE between “OR” and Google Button
        Spacer(modifier = Modifier.height(20.dp))

        // -------- Google Button --------
        IconButton(onClick = {}) {
            Icon(
                painter = painterResource(id = R.drawable.google),
                contentDescription = "Google Button",
                tint = Color.Unspecified,
                modifier = Modifier
                    .size(60.dp)
                    .border(
                        width = 1.dp,
                        color = Color.LightGray,
                        shape = CircleShape
                    )
                    .padding(10.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewOrComponent() {
    OrComponent()
}



