package com.ssu.portfolio.fooddeliveryapp.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ssu.portfolio.fooddeliveryapp.R

// Sealed class (typos fixed)
sealed class cardItem {
    data class ColoummGrid(val name: String) : cardItem()
    data class FirstCard(val profilename: String, val percentagetext: String) : cardItem()
    data class SecondCard(val vegtext: String) : cardItem()
    data class ThirdCard(val apprearnce: String) : cardItem()
    data class FourthCard(val rating: String) : cardItem()
    data class FifthCard(val food_Order: String) : cardItem()
    data class SixthCard(val titlename: String) : cardItem()
    data class SeventhCard(val title: String) : cardItem()
    data class eighthCard(val title: String) : cardItem()
    data class ninthCard(val title: String) : cardItem()
    data class tenthCard(val title: String) : cardItem()
    data class eleventhcard(val title: String) : cardItem()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController) {
    Scaffold(
        modifier = Modifier.fillMaxWidth(),
        topBar = {
            TopAppBar(
                modifier = Modifier.background(color = colorResource(R.color.white)),
                title = { },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "ArrowBack"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = colorResource(R.color.purple_500))
                .padding(paddingValues)
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            // Profile Header Card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp)
                    .padding(horizontal = 10.dp),
                shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
                colors = CardDefaults.cardColors(Color.White)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = R.drawable.profielogo),
                        contentDescription = "Profile Image",
                        tint = Color.Unspecified
                    )
                    Spacer(modifier = Modifier.width(7.dp))
                    Column {
                        Text(
                            text = "Name",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 23.sp
                        )
                        Text(
                            text = "gmail2025gmail.com",
                            color = Color.DarkGray,
                            fontSize = 12.sp
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "View activity",
                            fontSize = 13.sp,
                            color = colorResource(id = R.color.purple_700)
                        )
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            tint = Color.DarkGray,
                            contentDescription = "Forward Arrow",
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }

            // Zomato Gold
            ZomatoGold()

            // Column Grid (outside LazyColumn)
            ColumnGrid(card = cardItem.ColoummGrid("Ayush"))

            // LazyColumn
            LazyColoumn()
        }
    }
}

@Composable
fun ZomatoGold() {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.Black),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .height(65.dp),
        shape = RoundedCornerShape(bottomEnd = 12.dp, bottomStart = 12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.goldicon1),
                contentDescription = "Zomato gold Image",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "Join Zomato Gold",
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.purple_200),
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "Arrow Right",
                tint = Color.White
            )
        }
    }
}

@Composable
fun ColumnGrid(card: cardItem.ColoummGrid) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Card(
            modifier = Modifier.weight(1f),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(vertical = 12.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.outline_bookmark_24),
                    contentDescription = "Collection",
                    tint = Color.Gray,
                    modifier = Modifier.size(30.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Collection",
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 15.sp
                )
            }
        }
        Spacer(modifier = Modifier.width(10.dp))
        Card(
            modifier = Modifier.weight(1f),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(vertical = 12.dp)
            ) {
                Icon(
                    painter = painterResource(R.drawable.rupeesymbol),
                    contentDescription = "Money",
                    tint = Color.Gray,
                    modifier = Modifier.size(30.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Money",
                        color = Color.Black,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Box(
                        modifier = Modifier
                            .size(width = 30.dp, height = 20.dp)
                            .background(
                                color = colorResource(R.color.purple_200),
                                shape = RoundedCornerShape(8.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "0",
                            color = colorResource(R.color.purple_500),
                            fontSize = 14.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun LazyColoumn() {
    val cardlist = listOf(
        cardItem.FirstCard(profilename = "Your Profile", percentagetext = "40% Completed"),
        cardItem.SecondCard(vegtext = "Veg Mode"),
        cardItem.ThirdCard(apprearnce = "Appearance"),
        cardItem.FourthCard(rating = "Your rating"),
        cardItem.FifthCard(food_Order = "Food Orders"),
        cardItem.SixthCard(titlename = "Dining and Experience"),
        cardItem.SeventhCard(title = "Payments"),
        cardItem.eighthCard(title = "Help & Support"),
        cardItem.ninthCard(title = "About"),
        cardItem.tenthCard(title = "Send Feedback"),
        cardItem.eleventhcard(title = "Logout")
    )

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(cardlist) { item ->
            when (item) {
                is cardItem.ColoummGrid -> {} // Not used here
                is cardItem.FirstCard -> ProfileCard(item)
                is cardItem.SecondCard -> VegModeCard(item)
                is cardItem.ThirdCard -> AppearanceCard(item)
                is cardItem.FourthCard -> RatingCard(item)
                is cardItem.FifthCard -> FoodOrderCard(item)
                is cardItem.SixthCard -> DiningCard(item)
                is cardItem.SeventhCard -> seventhCard(item)
                is cardItem.eighthCard -> eightCard(item)
                is cardItem.ninthCard -> ninthCard(item)
                is cardItem.tenthCard -> tenthCardd(item)
                is cardItem.eleventhcard -> eleventhCard(item)
            }
        }
    }
}

// Fixed ProfileCard
@Composable
fun ProfileCard(card: cardItem.FirstCard) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Left Icon
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "Profile Icon",
                tint = Color.Gray,
                modifier = Modifier.size(28.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            // Profile Text
            Text(
                text = card.profilename,
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.weight(1f))

            // Badge Text
            Text(
                text = card.percentagetext,
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp,
                modifier = Modifier
                    .background(
                        colorResource(R.color.purple_700),
                        RoundedCornerShape(12.dp)
                    )
                    .padding(horizontal = 10.dp, vertical = 4.dp)
            )

            Spacer(modifier = Modifier.width(10.dp))

            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "Next",
                tint = Color.DarkGray,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}


// Fixed VegModeCard
@Composable
fun VegModeCard(card: cardItem.SecondCard) {
    var switch1 by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.veg_icon),
                contentDescription = "Veg Mode Icon",
                modifier = Modifier.size(22.dp),
                tint = colorResource(R.color.purple_200)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = card.vegtext, color = Color.Black)
            Spacer(modifier = Modifier.weight(1f))
            Switch(
                checked = switch1,
                onCheckedChange = { switch1 = it },
                colors = SwitchDefaults.colors(
                    checkedTrackColor = Color.Green,
                    uncheckedTrackColor = Color.LightGray
                )
            )
        }
    }
}

// Fixed AppearanceCard
@Composable
fun AppearanceCard(card: cardItem.ThirdCard) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.paint),
                contentDescription = "Appearance",
                modifier = Modifier.size(20.dp),
                tint = Color.LightGray
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = card.apprearnce, color = Color.Black)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "LIGHT", fontWeight = FontWeight.Bold, color = Color.Gray)
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "forward arrow",
                tint = Color.Gray
            )
        }
    }
}

// Fixed RatingCard
@Composable
fun RatingCard(card: cardItem.FourthCard) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 6.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.rating),
                contentDescription = "Rating Icon",
                modifier = Modifier.size(25.dp),
                tint = Color.LightGray
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = card.rating, color = Color.Black)
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painter = painterResource(R.drawable.startrating),
                contentDescription = "star rating",
                tint = Color.Unspecified
            )
        }
    }
}

// Fixed FoodOrderCard (main layout fix)
@Composable
fun FoodOrderCard(card: cardItem.FifthCard) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 6.dp)
            .height(400.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                VerticalDivider(
                    thickness = 3.dp,
                    modifier = Modifier
                        .height(34.dp)
                        .padding(top = 12.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    color = colorResource(R.color.purple_500)
                )
                Text(
                    text = card.food_Order,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp)
                )
            }

            // All menu items with divider
            val menuItems = listOf(
                "Your orders" to R.drawable.order,
                "Favorite orders" to Icons.Default.FavoriteBorder,
                "Manage recommendations" to R.drawable.thumbs,
                "Order on train" to R.drawable.train,
                "Address book" to R.drawable.addressbook,
                "Hidden Restaurants" to R.drawable.hiddden,
                "Online ordering help" to R.drawable.message
            )

            menuItems.forEachIndexed { index, (title, iconRes) ->
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        if (iconRes is Int) {
                            Icon(
                                painter = painterResource(iconRes),
                                contentDescription = title,
                                modifier = Modifier.size(25.dp),
                                tint = Color.LightGray
                            )
                        } else if (iconRes is androidx.compose.ui.graphics.vector.ImageVector) {
                            Icon(
                                imageVector = iconRes,
                                contentDescription = title,
                                modifier = Modifier.size(25.dp),
                                tint = Color.LightGray
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(text = title, color = Color.Black)
                        Spacer(modifier = Modifier.weight(1f))
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                            contentDescription = "forward arrow",
                            tint = Color.Gray
                        )
                    }
                    if (index < menuItems.size - 1) {
                        HorizontalDivider(
                            thickness = 0.5.dp,
                            color = Color.LightGray.copy(alpha = 0.4f),
                            modifier = Modifier.padding(start = 45.dp)
                        )
                    }
                }
            }
        }
    }
}

// Placeholder for other cards (you can fill later)

@Composable
fun DiningCard(card: cardItem.SixthCard) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 10.dp)
            .fillMaxWidth()
            .height(350.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column {
            Row {
                VerticalDivider(
                    thickness = 3.dp,
                    modifier = Modifier
                        .height(34.dp)
                        .padding(top = 12.dp)
                        .clip(shape = RoundedCornerShape(10.dp)),
                    color = colorResource(R.color.purple_500)
                )
                Text(
                    text = "Dining and Experiences",
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Rating icon need to bee added download
                Icon(
                    painter = painterResource(R.drawable.hiddden),
                    contentDescription = "Your orders",
                    modifier = Modifier.size(25.dp),
                    tint = Color.LightGray
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "your dining transactions", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))
                Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    tint = Color.Gray)
            }

            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier
                    .padding(start = 53.dp, top = 10.dp)
                    .weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Rating icon need to bee added download
                Icon(
                    painter = painterResource(R.drawable.gift),
                    contentDescription = "Your Profile",
                    modifier = Modifier.size(25.dp),
                    tint = Color.LightGray
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Your dining rewards", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    tint = Color.Gray
                )
            }
            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier
                    .padding(start = 53.dp, top = 10.dp)
                    .weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Rating icon need to bee added download
                Icon(
                    painter = painterResource(R.drawable.dining),
                    contentDescription = "Your Profile",
                    modifier = Modifier.size(25.dp),
                    tint = Color.LightGray
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Your bookings", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    tint = Color.Gray
                )
            }
            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier
                    .padding(start = 53.dp, top = 10.dp)
                    .weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Rating icon need to bee added download
                Icon(
                    painter = painterResource(R.drawable.message),
                    contentDescription = "Your Profile",
                    modifier = Modifier.size(25.dp),
                    tint = Color.LightGray
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Dining help", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    tint = Color.Gray
                )
            }

            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier
                    .padding(start = 53.dp, top = 10.dp)
                    .weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Rating icon need to bee added download
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Your Profile",
                    modifier = Modifier.size(25.dp),
                    tint = Color.LightGray
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Dining settings", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    tint = Color.Gray
                )
            }
            HorizontalDivider(
                thickness = 0.5.dp,
                modifier = Modifier
                    .padding(start = 53.dp, top = 10.dp)
                    .weight(0.2f),
                color = Color.LightGray.copy(alpha = 0.4f)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Rating icon need to be added download
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "Your Profile",
                    modifier = Modifier.size(25.dp),
                    tint = Color.LightGray
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Frequently asked questions", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    tint = Color.Gray
                )
            }

            Spacer(modifier = Modifier.width(4.dp))
        }
    }
}


@Composable
fun seventhCard(card: cardItem.SeventhCard) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 10.dp)
            .fillMaxWidth()
            .height(120.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column {
            Row {
                VerticalDivider(
                    thickness = 3.dp,
                    modifier = Modifier
                        .height(34.dp)
                        .padding(top = 12.dp)
                        .clip(shape = RoundedCornerShape(10.dp)),
                    color = colorResource(R.color.purple_700)
                )
                Text(
                    text = "Feeding India",
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Rating icon need to be added download
                Icon(
                    painter = painterResource(R.drawable.impact),
                    contentDescription = "Your orders",
                    modifier = Modifier.size(25.dp),
                    tint = Color.LightGray
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Your impact", color = Color.Black)
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    tint = Color.Gray
                )

                HorizontalDivider(
                    thickness = 0.5.dp,
                    modifier = Modifier
                        .padding(start = 53.dp, top = 10.dp)
                        .weight(0.2f),
                    color = Color.LightGray.copy(alpha = 0.4f)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Rating icon need to be added download
                    Icon(
                        painter = painterResource(R.drawable.reciept),
                        contentDescription = "Your orders",
                        modifier = Modifier.padding(start = 10.dp),
                        tint = Color.LightGray
                    )

                    Text(
                        text = "Get Feeding India receipt",
                        color = Color.Black,
                        modifier = Modifier
                            .padding(start = 5.dp, top = 10.dp)
                            .weight(1f)
                    )

                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = "forward arrow",
                        modifier = Modifier.padding(start = 5.dp, top = 10.dp),
                        tint = Color.Gray
                    )
                }
            }
        }
    }
}


@Composable
fun eightCard(card: cardItem.eighthCard) {

    Card(
        modifier = Modifier
            .padding(start = 10.dp, top = 13.dp, end = 10.dp)
            .fillMaxWidth()
            .height(310.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {

        Column {

            // -------- TITLE ROW --------
            Row {
                VerticalDivider(
                    thickness = 3.dp,
                    modifier = Modifier
                        .height(34.dp)
                        .padding(top = 12.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    color = colorResource(R.color.purple_700)
                )
                Text(
                    text = "Money",
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp)
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            // -------- ROW 1 --------
            RowItem(
                icon = painterResource(R.drawable.rupeesymbol),
                label = "Zomato Money"
            )
            DividerItem()

            // -------- ROW 2 --------
            RowItem(
                icon = painterResource(R.drawable.giftcard),
                label = "Buy Gift Card"
            )
            DividerItem()

            // -------- ROW 3 --------
            RowItem(
                icon = painterResource(R.drawable.claimgiftcard),
                label = "Claim Gift Card"
            )
            DividerItem()

            // -------- ROW 4 --------
            RowItem(
                icon = painterResource(R.drawable.z),
                label = "Zomato Credits"
            )
            DividerItem()

            // -------- ROW 5 --------
            RowItem(
                icon = painterResource(R.drawable.payment),
                label = "Payment Settings"
            )
        }
    }
}

@Composable
fun RowItem(icon: Painter, label: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            painter = icon,
            contentDescription = label,
            modifier = Modifier.padding(start = 10.dp),
            tint = Color.LightGray
        )

        Text(
            text = label,
            color = Color.Black,
            modifier = Modifier
                .padding(start = 5.dp)
                .weight(1f)
        )

        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = "arrow",
            modifier = Modifier.padding(end = 10.dp),
            tint = Color.Gray
        )
    }
}

@Composable
fun DividerItem() {
    HorizontalDivider(
        thickness = 0.5.dp,
        modifier = Modifier
            .padding(start = 53.dp)
            .fillMaxWidth(),
        color = Color.LightGray.copy(alpha = 0.4f)
    )
}

@Composable
fun ninthCard(card: cardItem.ninthCard) {
    Card(
        modifier = Modifier
            .padding(start = 10.dp, top = 13.dp, end = 10.dp)
            .fillMaxWidth()
            .height(120.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column {
            Row {
                VerticalDivider(
                    thickness = 3.dp,
                    modifier = Modifier
                        .height(34.dp)
                        .padding(top = 12.dp)
                        .clip(shape = RoundedCornerShape(10.dp)),
                    color = colorResource(R.color.purple_700)
                )
                Text(
                    text = "Zomato For Enterprise",
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp)
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Rating icon need to be added download
                Icon(
                    painter = painterResource(R.drawable.building),
                    contentDescription = "Your orders",
                    modifier = Modifier.padding(start = 10.dp),
                    tint = Color.LightGray
                )
                Text(
                    text = "For employs",
                    color = Color.Black,
                    modifier = Modifier
                        .padding(start = 5.dp, top = 10.dp)
                        .weight(1f)
                )
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "forward arrow",
                    modifier = Modifier.padding(start = 5.dp, top = 10.dp),
                    tint = Color.Gray
                )
            }
        }
    }
}



@Composable
fun RowItem(
    icon: Painter,
    label: String,
    showDivider: Boolean = true
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                painter = icon,
                contentDescription = label,
                modifier = Modifier.padding(start = 10.dp),
                tint = Color.LightGray
            )

            Text(
                text = label,
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 5.dp)
                    .weight(1f)
            )

            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "arrow",
                modifier = Modifier.padding(end = 10.dp),
                tint = Color.Gray
            )
        }

        if (showDivider) {
            DividerItem()
        }
    }
}

@Composable
fun tenthCardd(card: cardItem.tenthCard) {

    Card(
        modifier = Modifier
            .padding(start = 10.dp, top = 13.dp, end = 10.dp)
            .fillMaxWidth()
            .height(120.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {

        Column {

            // Title
            Row {
                VerticalDivider(
                    thickness = 3.dp,
                    modifier = Modifier
                        .height(34.dp)
                        .padding(top = 12.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    color = colorResource(R.color.purple_500)
                )
                Text(
                    text = "Coupons",
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp)
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            RowItem(
                icon = painterResource(R.drawable.coupons),
                label = "Collected coupons"
            )

            RowItem(
                icon = painterResource(R.drawable.empcard),
                label = "For employees",
                showDivider = false
            )
        }
    }
}


@Composable
fun eleventhCard(card: cardItem.eleventhcard) {

    Card(
        modifier = Modifier
            .padding(start = 10.dp, top = 13.dp, end = 10.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {

        Column {

            Row {
                VerticalDivider(
                    thickness = 3.dp,
                    modifier = Modifier
                        .height(34.dp)
                        .padding(top = 12.dp)
                        .clip(RoundedCornerShape(10.dp)),
                    color = colorResource(R.color.purple_500)
                )
                Text(
                    text = "More",
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp)
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            RowItem(
                icon = painterResource(R.drawable.outline_info_24),
                label = "About"
            )

            RowItem(
                icon = painterResource(R.drawable.feedback),
                label = "Send feedback"
            )

            RowItem(
                icon = painterResource(R.drawable.outline_info_24),
                label = "Report a safety emergency"
            )

            RowItem(
                icon = painterResource(R.drawable.outline_info_24),
                label = "Settings"
            )

            RowItem(
                icon = painterResource(R.drawable.logout),
                label = "Logout",
                showDivider = false
            )
        }
    }
}

@Preview
@Composable
private fun PreviewProfile() {
    ProfileScreen(rememberNavController())
}