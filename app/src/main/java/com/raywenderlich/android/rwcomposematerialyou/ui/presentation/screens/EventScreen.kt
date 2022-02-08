package com.raywenderlich.android.rwcomposematerialyou.ui.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.raywenderlich.android.rwcomposematerialyou.ui.data.models.Events
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.composables.*
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.viewmodels.EventsViewModel

@ExperimentalMaterial3Api
@Composable
fun EventScreen(navController: NavController, eventsViewModel: EventsViewModel) {
Scaffold(
  modifier = Modifier
    .fillMaxSize()
    .background(color = Color.LightGray),
  topBar = { BackTopBar("Add Event") { navController.popBackStack() } } ,
  content = {
    eventsViewModel.addEvent(
      Events(
        id = 0,
        "First Event",
        "First demo event",
        "Blue",
        "12.34.12"
      )
    )
    EventInputs()
  }
)
}

@Composable
fun EventInputs() {
  Column(modifier =
  Modifier
    .padding(6.dp)
    .fillMaxSize()
  ) {
    EventInputText("Name")
    Spacer(modifier = Modifier
      .padding(top = 10.dp))
    EventInputText("Description")
    Spacer(modifier = Modifier
      .padding(top = 10.dp))
    DatePicker()
    Spacer(modifier = Modifier
      .padding(top = 10.dp))
    ColorPicker()
    Spacer(modifier = Modifier
      .padding(top = 10.dp))
    EventInputText("Name")
    Spacer(modifier = Modifier
      .padding(top = 10.dp))
    SaveButton()
  }
}


@ExperimentalMaterial3Api
@Preview
@Composable
fun EventScreenPreview() {
EventInputs()
}