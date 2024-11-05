package com.lacolinares.phtyphoon.ui.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.lacolinares.phtyphoon.ui.screen.detail.DetailScreen
import com.lacolinares.phtyphoon.ui.screen.home.HomeScreen
import com.lacolinares.phtyphoon.ui.util.TyphoonType
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Routes.HomeScreen,
        enterTransition = { slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Start, tween(700)) },
        exitTransition = { slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Start, tween(700)) },
        popEnterTransition = { slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.End, tween(700)) },
        popExitTransition = { slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.End, tween(700)) }
    ) {
        composable<Routes.HomeScreen> {
            HomeScreen(
                onClickDeadliestTyphoon = { typhoon ->
                    val deadliestTyphoon: TyphoonType = TyphoonType.Deadliest(typhoon)
                    val type: String = Json.encodeToString(deadliestTyphoon)
                    navController.navigate(Routes.DetailScreen(type))
                },
                onClickDestructiveTyphoon = { typhoon ->
                    val destructiveTyphoon: TyphoonType = TyphoonType.Destructive(typhoon)
                    val type: String = Json.encodeToString(destructiveTyphoon)
                    navController.navigate(Routes.DetailScreen(type))
                }
            )
        }

        composable<Routes.DetailScreen> {
            val args = it.toRoute<Routes.DetailScreen>()
            val type: TyphoonType = Json.decodeFromString(args.type)
            DetailScreen(type)
        }
    }
}