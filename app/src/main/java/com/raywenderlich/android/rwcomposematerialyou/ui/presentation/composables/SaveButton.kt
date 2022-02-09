package com.raywenderlich.android.rwcomposematerialyou.ui.presentation.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.viewmodels.EventsViewModel

@Composable
fun SaveButton(eventsViewModel: EventsViewModel, navController: NavController) {
  ElevatedButton(
    onClick = {
      eventsViewModel.addEvent()
      navController.popBackStack()
    },
    modifier = Modifier
      .fillMaxWidth()
      .padding(10.dp)
  ) {
    Text(text = "Save Event")
  }
}