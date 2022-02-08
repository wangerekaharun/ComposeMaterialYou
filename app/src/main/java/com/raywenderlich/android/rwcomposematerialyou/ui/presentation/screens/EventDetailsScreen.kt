package com.raywenderlich.android.rwcomposematerialyou.ui.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.composables.BackTopBar

@ExperimentalMaterial3Api
@Composable
fun EventDetailsScreen(navController: NavController) {
  Scaffold(
    modifier = Modifier
      .fillMaxSize()
      .background(color = Color.LightGray),
    topBar = { BackTopBar("Event Details") { navController.popBackStack() } } ,
    content = {

    }
  )
}
