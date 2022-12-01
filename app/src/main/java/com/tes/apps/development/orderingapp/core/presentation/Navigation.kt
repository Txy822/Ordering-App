package com.tes.apps.development.orderingapp.core.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tes.apps.development.orderingapp.order_feature.presentation.OrderScreen

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(
        navController,
        startDestination = ScreenRoutes.OrderScreen.route
    ){
        composable(ScreenRoutes.OrderScreen.route){
            OrderScreen(navController = navController)
        }

    }

}

sealed class ScreenRoutes(val route:String){
    object OrderScreen:ScreenRoutes("order_screen")
}