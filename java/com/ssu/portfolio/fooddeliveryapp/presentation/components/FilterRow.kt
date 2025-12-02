package com.ssu.portfolio.fooddeliveryapp.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ssu.portfolio.fooddeliveryapp.R

@Composable
fun FilterRow(filters: List<String>) {

    var selectedFilter by remember { mutableStateOf<String?>(null) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        LazyRow(
            modifier = Modifier.weight(2f),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            items(filters) { filter ->

                FilterChip(
                    selected = selectedFilter == filter,
                    onClick = {
                        selectedFilter = if (selectedFilter == filter) null else filter
                    },
                    label = {
                        Text(text = filter, fontSize = 12.sp)
                    },

                    colors = FilterChipDefaults.filterChipColors(
                        containerColor = Color.White,
                        labelColor = Color.DarkGray,
                        selectedContainerColor = colorResource(R.color.teal_200)
                    ),

                    border = BorderStroke(0.4.dp, color = colorResource(R.color.teal_200)),

                    leadingIcon = {
                        when (filter) {

                            "Filters" -> Icon(
                                painter = painterResource(R.drawable.dining),
                                contentDescription = null,
                                tint = Color.Unspecified,
                                modifier = Modifier.size(18.dp)
                            )

                            "Flash Sale" -> Icon(
                                painter = painterResource(R.drawable.snack_meal),
                                contentDescription = null,
                                tint = Color.Unspecified,
                                modifier = Modifier.size(18.dp)
                            )

                            "Under 30 mins" -> Icon(
                                painter = painterResource(R.drawable.timer),
                                contentDescription = null,
                                tint = Color.Unspecified,
                                modifier = Modifier.size(18.dp)
                            )

                            "Rating" -> Icon(
                                painter = painterResource(R.drawable.rating),
                                contentDescription = null,
                                tint = Color.Unspecified,
                                modifier = Modifier.size(18.dp)
                            )

                            "Schedule" -> Icon(
                                painter = painterResource(R.drawable.notes),
                                contentDescription = null,
                                tint = Color.Unspecified,
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    },

                    trailingIcon = {
                        if (selectedFilter == filter) {
                            Icon(
                                painter = painterResource(R.drawable.close),
                                contentDescription = null,
                                tint = Color.Unspecified,
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    }
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewFilterRow() {
    FilterRow(
        filters = listOf(
            "Filters",
            "Flash Sale",
            "Under 30 mins",
            "Rating",
            "Schedule"
        )
    )
}
