package com.ssu.portfolio.fooddeliveryapp.data.models

import android.media.Image

data class FoodCategoryData(
    val name: String,
    val image: Int
)

data class  TabItem(
    val title: String
)

data class  FoodCategory(
    val name: String,
    val imageRes: Int
)