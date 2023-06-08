package com.dag.hacettepemobil.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.dag.hacettepemobil.component.HacettepeSurface
import com.dag.hacettepemobil.component.appbar.HacettepeAppbar
import com.dag.hacettepemobil.features.onboard.OnboardActivity

@Composable
fun NavGraph(
    startDestination: String = NavScreen.OnboardScreen.route,
    isOnboard: Boolean = false,
){
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    HacettepeSurface(
        appbar = {
            if (!isOnboard){
                HacettepeAppbar(username = "Dogukan", department = "Informatics")
            }
        },
        bottomBar = {},
        backgroundColor = Color.White
    ) {
        NavHost(
            navController = navController,
            startDestination = startDestination
        ){
            composable(NavScreen.OnboardScreen.route){
                // Onboard Screen starts with permissions
            }
        }
    }

}