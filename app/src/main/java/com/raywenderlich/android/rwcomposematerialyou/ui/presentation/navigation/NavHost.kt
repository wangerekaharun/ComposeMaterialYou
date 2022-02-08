package com.raywenderlich.android.rwcomposematerialyou.ui.presentation.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.screens.EventDetailsScreen
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.screens.EventScreen
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.screens.HomeScreen

@ExperimentalMaterial3Api
@Composable
fun AppNavigation(navController: NavHostController) {
  NavHost(
    navController = navController,
    startDestination = "homeScreen"
  ) {
    composable("homeScreen") {
      HomeScreen(navController)
    }
    composable("eventInputScreen") {
      EventScreen(navController)
    }
    composable("eventDetailsScreen") {
      EventDetailsScreen(navController)
    }
  }
}