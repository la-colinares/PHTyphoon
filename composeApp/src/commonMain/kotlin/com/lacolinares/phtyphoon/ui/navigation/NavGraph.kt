package com.lacolinares.phtyphoon.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.lacolinares.phtyphoon.ui.screen.detail.DetailScreen
import com.lacolinares.phtyphoon.ui.screen.home.HomeScreen


@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.HomeScreen
    ) {
        composable<Routes.HomeScreen> {
            HomeScreen(
                onClickTyphoon = {
                    navController.navigate(Routes.DetailScreen("Test"))
                }
            )
        }

        composable<Routes.DetailScreen> {
            val args = it.toRoute<Routes.DetailScreen>()
            DetailScreen(args.data)
        }
    }
}