package com.raywenderlich.android.rwcomposematerialyou.ui.presentation.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.shrinkOut
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.screens.EventScreen
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.screens.HomeScreen
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.viewmodels.EventsViewModel

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@ExperimentalMaterial3Api
@Composable
fun AppNavigation(navController: NavHostController, eventsViewModel: EventsViewModel) {
  AnimatedNavHost(
    navController = navController,
    startDestination = Screens.HomeScreen.route,
    enterTransition = { expandIn(animationSpec = tween(800)) },
    exitTransition = { shrinkOut(animationSpec = tween(800)) }
  ) {
    composable(Screens.HomeScreen.route,
      enterTransition = {
        when (initialState.destination.route) {
          Screens.EventInputScreen.route ->
            slideIntoContainer(
              AnimatedContentScope.SlideDirection.Left,
              animationSpec = tween(600)
            )
          else -> null
        }
      },
      exitTransition = {
        when (targetState.destination.route) {
          Screens.EventInputScreen.route ->
            slideOutOfContainer(
              AnimatedContentScope.SlideDirection.Left,
              animationSpec = tween(600)
            )
          else -> null
        }
      },
      popEnterTransition = {
        when (initialState.destination.route) {
          Screens.EventInputScreen.route ->
            slideIntoContainer(
              AnimatedContentScope.SlideDirection.Right,
              animationSpec = tween(600)
            )
          else -> null
        }
      },
      popExitTransition = {
        when (targetState.destination.route) {
          Screens.EventInputScreen.route ->
            slideOutOfContainer(
              AnimatedContentScope.SlideDirection.Right,
              animationSpec = tween(600)
            )
          else -> null
        }
      }
    ) {
      HomeScreen(navController, eventsViewModel)
    }
    composable(Screens.EventInputScreen.route,
      enterTransition = {
        when (initialState.destination.route) {
          Screens.HomeScreen.route ->
            slideIntoContainer(
              AnimatedContentScope.SlideDirection.Left,
              animationSpec = tween(600)
            )
          else -> null
        }
      },
      exitTransition = {
        when (targetState.destination.route) {
          Screens.HomeScreen.route ->
            slideOutOfContainer(
              AnimatedContentScope.SlideDirection.Left,
              animationSpec = tween(600)
            )
          else -> null
        }
      },
      popEnterTransition = {
        when (initialState.destination.route) {
          Screens.HomeScreen.route ->
            slideIntoContainer(
              AnimatedContentScope.SlideDirection.Right,
              animationSpec = tween(600)
            )
          else -> null
        }
      },
      popExitTransition = {
        when (targetState.destination.route) {
          Screens.HomeScreen.route ->
            slideOutOfContainer(
              AnimatedContentScope.SlideDirection.Right,
              animationSpec = tween(600)
            )
          else -> null
        }
      }
    ) {
      EventScreen(navController, eventsViewModel)
    }
  }
}