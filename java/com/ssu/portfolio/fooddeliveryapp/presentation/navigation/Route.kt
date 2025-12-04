package com.ssu.portfolio.fooddeliveryapp.presentation.navigation

import kotlinx.serialization.Serializable


sealed class SubNavigation{
    @Serializable
    object LoginSignupScreen : SubNavigation()

    @Serializable
    object  MainHomeScreen: SubNavigation()
}


sealed class  Routes{

    @Serializable
    object LoginScreen : Routes()

    @Serializable
    object SignUpScreen : Routes()

    @Serializable
    object DeliveryScreen : Routes()

    @Serializable
    object QuickScreen : Routes()

    @Serializable
    object DiningScreen : Routes()

    @Serializable
    object ProfileScreen : Routes()

    @Serializable
    object ParticularScreen : Routes()

    @Serializable
    object FinalCheckoutScreen : Routes()

    @Serializable
    object SearchBarScreen : Routes()
}