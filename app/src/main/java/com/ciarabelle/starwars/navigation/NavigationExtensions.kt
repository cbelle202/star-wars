package com.ciarabelle.starwars.navigation

import androidx.navigation.NavController

fun NavController.navigateUpTo(route: String) {
    navigate(route) {
        popUpTo(route = route)
        launchSingleTop = true
    }
}

fun NavController.navigateToRoot() {
    navigateUpTo(graph.startDestinationRoute ?: ROOT)
}