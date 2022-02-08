package com.raywenderlich.android.rwcomposematerialyou.ui.presentation.navigation

sealed class Screens(val route: String) {
  object HomeScreen : Screens("homeScreen")
  object EventInputScreen : Screens("eventInputScreen")
  object EventDetails : Screens("eventDetailsScreen")
}