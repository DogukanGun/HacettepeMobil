package com.dag.hacettepemobil.navigation

sealed class NavScreen(val route:String){
    object OnboardScreen: NavScreen("onboard")
    object LanguageSelection: NavScreen("language")
    object Login: NavScreen("login")
    object Register: NavScreen("register")
    object HomeScreen: NavScreen("home")
}

fun NavScreen.addData(data:Any):String{
    return this.route.plus(data)
}

fun NavScreen.addPath(path:String):String{
    return this.route.plus("/").plus(path)
}