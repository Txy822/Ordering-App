package com.tes.apps.development.orderingapp.core.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(
        navController,
        startDestination = ScreenRoutes.OrderScreen.route
    ){
        composable(ScreenRoutes.OrderScreen.route){
            ScreenRoutes.OrderScreen(navController = navController)
        }
        composable(ScreenRoutes.OrderChooseDelivererScreen.route){
            ScreenRoutes.OrderChooseDelivererScreen(navController = navController)
        }

        composable(ScreenRoutes.OrderChooseProductsScreen.route+"/{delivererId}"){
            ScreenRoutes.OrderChooseProductsScreen(
                navController = navController,
                delivererId = it.arguments?.getString("delivererId")
            )
        }
    }

}

sealed class ScreenRoutes(val route:String){
    object OrderScreen:ScreenRoutes("order_screen")
    object OrderChooseDelivererScreen:ScreenRoutes("order_choose_deliverer_screen")
    object OrderChooseProductsScreen:ScreenRoutes("order_choose_prodcuts_screen")
}