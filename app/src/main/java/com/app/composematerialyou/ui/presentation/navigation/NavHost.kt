/*
 * Copyright (c) 2022 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * This project and source code may use libraries or frameworks that are
 * released under various Open-Source licenses. Use of those libraries and
 * frameworks are governed by their own individual licenses.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.app.composematerialyou.ui.presentation.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.shrinkOut
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import com.app.composematerialyou.ui.presentation.screens.EventScreen
import com.app.composematerialyou.ui.presentation.screens.HomeScreen
import com.app.composematerialyou.ui.presentation.viewmodels.EventsViewModel
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable

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
        if (initialState.destination.route == Screens.EventInputScreen.route) slideIntoContainer(
          AnimatedContentScope.SlideDirection.Left,
          animationSpec = tween(600)
        )
        else null
      },
      exitTransition = {
        if (targetState.destination.route == Screens.EventInputScreen.route) slideOutOfContainer(
          AnimatedContentScope.SlideDirection.Left,
          animationSpec = tween(600)
        )
        else null
      },
      popEnterTransition = {
        if (initialState.destination.route == Screens.EventInputScreen.route) slideIntoContainer(
          AnimatedContentScope.SlideDirection.Right,
          animationSpec = tween(600)
        )
        else null
      },
      popExitTransition = {
        if (targetState.destination.route == Screens.EventInputScreen.route) slideOutOfContainer(
          AnimatedContentScope.SlideDirection.Right,
          animationSpec = tween(600)
        )
        else null
      }
    ) {
      HomeScreen(navController, eventsViewModel)
    }
    composable(Screens.EventInputScreen.route,
      enterTransition = {
        if (initialState.destination.route == Screens.HomeScreen.route) slideIntoContainer(
          AnimatedContentScope.SlideDirection.Left,
          animationSpec = tween(600)
        )
        else null
      },
      exitTransition = {
        if (targetState.destination.route == Screens.HomeScreen.route) slideOutOfContainer(
          AnimatedContentScope.SlideDirection.Left,
          animationSpec = tween(600)
        )
        else null
      },
      popEnterTransition = {
        if (initialState.destination.route == Screens.HomeScreen.route) slideIntoContainer(
          AnimatedContentScope.SlideDirection.Right,
          animationSpec = tween(600)
        )
        else null
      },
      popExitTransition = {
        if (targetState.destination.route == Screens.HomeScreen.route) slideOutOfContainer(
          AnimatedContentScope.SlideDirection.Right,
          animationSpec = tween(600)
        )
        else null
      }
    ) {
      EventScreen(navController, eventsViewModel)
    }
  }
}