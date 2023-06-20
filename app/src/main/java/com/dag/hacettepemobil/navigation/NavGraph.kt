package com.dag.hacettepemobil.navigation

import androidx.activity.OnBackPressedCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.dag.hacettepemobil.base.settings.SettingsService
import com.dag.hacettepemobil.component.HacettepeSurface
import com.dag.hacettepemobil.component.appbar.HacettepeAppbar
import com.dag.hacettepemobil.features.onboard.OnboardActivity
import com.dag.hacettepemobil.features.onboard.language.LanguageSelection
import com.dag.hacettepemobil.features.onboard.language.LanguageVM
import com.dag.hacettepemobil.features.onboard.login.Login
import com.dag.hacettepemobil.features.onboard.permissions.AskUserPermissionsVM
import com.dag.hacettepemobil.features.onboard.permissions.UserPermissionOnboard

@Composable
fun NavGraph(
    startDestination: String = NavScreen.OnboardScreen.route,
    isOnboard: Boolean = false,
    settingsService: SettingsService
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
                val viewModel = hiltViewModel<AskUserPermissionsVM>()
                UserPermissionOnboard(
                    viewModel = viewModel,
                    navController = navController
                )
            }
            composable(NavScreen.LanguageSelection.route){
                val viewModel = hiltViewModel<LanguageVM>()
                LanguageSelection(
                    settingsService = settingsService,
                    viewModel = viewModel,
                    navController = navController
                )
            }
            composable(NavScreen.Login.route){
                Login(settingsService = settingsService)
                if (isOnboard) {
                    val lifecycleOwner = LocalLifecycleOwner.current
                    val onBackPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher

                    DisposableEffect(lifecycleOwner, onBackPressedDispatcher) {
                        val onBackPressedCallback = object : OnBackPressedCallback(true) {
                            override fun handleOnBackPressed() {
                                // Do nothing to disable the back button
                            }
                        }

                        onBackPressedCallback.isEnabled = true
                        onBackPressedDispatcher?.addCallback(lifecycleOwner, onBackPressedCallback)

                        onDispose {
                            onBackPressedCallback.remove()
                        }
                    }
                }

            }
        }
    }

}