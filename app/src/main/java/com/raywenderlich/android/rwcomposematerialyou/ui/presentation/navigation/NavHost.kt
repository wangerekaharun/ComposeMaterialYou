package com.raywenderlich.android.rwcomposematerialyou.ui.presentation.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.screens.EventDetailsScreen
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.screens.EventScreen
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.screens.HomeScreen
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.viewmodels.EventsViewModel

@ExperimentalComposeUiApi
@ExperimentalMaterial3Api
@Composable
fun AppNavigation(navController: NavHostController, eventsViewModel: EventsViewModel) {
  NavHost(
    navController = navController,
    startDestination = Screens.HomeScreen.route
  ) {
    composable("homeScreen") {
      HomeScreen(navController, eventsViewModel)
    }
    composable("eventInputScreen") {
      EventScreen(navController, eventsViewModel)
    }
    composable("eventDetailsScreen") {
      EventDetailsScreen(navController, eventsViewModel)
    }
  }
}