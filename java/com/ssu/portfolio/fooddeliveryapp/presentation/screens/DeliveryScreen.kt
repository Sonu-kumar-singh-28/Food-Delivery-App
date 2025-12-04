package com.ssu.portfolio.fooddeliveryapp.presentation.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.with
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ssu.portfolio.fooddeliveryapp.presentation.components.DeliveryScreenSearchBar
import com.ssu.portfolio.fooddeliveryapp.presentation.components.FoodCategoryTabs
import com.ssu.portfolio.fooddeliveryapp.presentation.components.TopAppBarDeliveryScreen
import com.ssu.portfolio.fooddeliveryapp.presentation.screens.CategoryScreen.AllCategoryScreen
import com.ssu.portfolio.fooddeliveryapp.presentation.screens.CategoryScreen.ChineseCategoryScreen
import com.ssu.portfolio.fooddeliveryapp.presentation.screens.CategoryScreen.PizzaCategoryScreen

@OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalFoundationApi::class,
    ExperimentalAnimationApi::class
)
@Composable
fun DeliveryScreen(navController: NavController, listState: LazyListState) {

    var selectedTabIndex by rememberSaveable { mutableIntStateOf(0) }

    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    Scaffold(
        topBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .windowInsetsPadding(WindowInsets.statusBars)
            ) {
                TopAppBarDeliveryScreen(scrollBehavior, navController)
                Spacer(modifier = Modifier.height(3.dp))
                DeliveryScreenSearchBar(navController)
            }
        }
    ) { innerPadding ->

        LazyColumn(
            state = listState,
            contentPadding = PaddingValues(vertical = 0.dp),
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(innerPadding)
                .nestedScroll(scrollBehavior.nestedScrollConnection)
        ) {

            // Sticky Tabs
            stickyHeader {
                FoodCategoryTabs(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White),
                    selectedTableIndex = selectedTabIndex,
                    onTableSelected = { selectedTabIndex = it }
                )
            }

            // Animated Tab Content
            item {
                AnimatedContent(
                    targetState = selectedTabIndex,
                    transitionSpec = {
                        if (targetState > initialState) {
                            slideInHorizontally { it } + fadeIn() with
                                    slideOutHorizontally { -it } + fadeOut()
                        } else {
                            slideInHorizontally { -it } + fadeIn() with
                                    slideOutHorizontally { it } + fadeOut()
                        }
                    },
                    label = "SlideTabTransition"
                ) { index ->

                    when (index) {
                        0-> AllCategoryScreen(navController)
                        1-> PizzaCategoryScreen(navController)
                        2-> ChineseCategoryScreen(navController)
                        else-> AllCategoryScreen(navController)
                    }
                }
            }
        }
    }
}
