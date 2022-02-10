package com.raywenderlich.android.rwcomposematerialyou.ui.presentation.screens

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.composables.*
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.viewmodels.EventsViewModel


@ExperimentalComposeUiApi
@ExperimentalMaterial3Api
@Composable
fun EventScreen(navController: NavController, eventsViewModel: EventsViewModel) {
  Scaffold(
    modifier = Modifier
      .fillMaxSize(),
    topBar = { BackTopBar("Add Event") { navController.popBackStack() } },
    content = {
      EventInputs(eventsViewModel, navController)
    }
  )
}

@ExperimentalComposeUiApi
@Composable
fun EventInputs(eventsViewModel: EventsViewModel, navController: NavController) {
  val activity = LocalContext.current as AppCompatActivity
  var datePicked by remember { mutableStateOf("") }
  val updatedDate = { date: String? ->
    datePicked = date ?: ""
  }

  Column(
    modifier =
    Modifier
      .fillMaxSize()
      .background(color = Color.LightGray)
  ) {
    EventNameInputText("Enter event name", eventsViewModel)
    DatePicker(datePicked, updatedDate, activity, eventsViewModel)
    EventDescriptionInputText("Enter event description", eventsViewModel)
    ColorPicker(eventsViewModel)
    SaveButton(eventsViewModel, navController)
  }
}