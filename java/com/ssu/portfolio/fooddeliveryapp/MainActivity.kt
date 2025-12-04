package com.ssu.portfolio.fooddeliveryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.ssu.portfolio.fooddeliveryapp.presentation.navigation.App
import com.ssu.portfolio.fooddeliveryapp.ui.theme.FoodDeliveryAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.distinctUntilChanged

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        enableEdgeToEdge()
        setContent {

            // Track scroll direction
            var isVisible by remember { mutableStateOf(value = true) }
            var lastIndex by remember { mutableStateOf(value = 0) }
            var lastScrollOffset by remember { mutableStateOf(value = 0) }
            val listState = rememberLazyListState()

// Listen to scroll events
            LaunchedEffect(listState) {
                snapshotFlow { listState.firstVisibleItemIndex to listState.firstVisibleItemScrollOffset }
                    .distinctUntilChanged()
                    .collect { (index, scrollOffset) ->

                        if (index > lastIndex || (index == lastIndex && scrollOffset > lastScrollOffset + 50)) {
                            // Scrolling Down -> Hide BottomNavBar
                            isVisible = false
                        } else if (index < lastIndex || (scrollOffset < lastScrollOffset - 50)) {
                            // Scrolling Up -> Show BottomNavBar
                            isVisible = true
                        }

                        lastIndex = index
                        lastScrollOffset = scrollOffset
                    }
            }

            FoodDeliveryAppTheme {
                App(
                    isVisible = isVisible,
                    listState = listState
                )
            }
        }
    }
}

