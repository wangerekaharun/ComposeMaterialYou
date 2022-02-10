package com.raywenderlich.android.rwcomposematerialyou.ui.presentation.composables

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.viewmodels.EventsViewModel

@Composable
fun SaveButton(eventsViewModel: EventsViewModel, navController: NavController) {
  val context = LocalContext.current

  FilledTonalButton(
    onClick = {
      if (eventsViewModel.validate()) {
        eventsViewModel.addEvent()
        navController.popBackStack()
      } else {
        Toast.makeText(context, "Please fill all the fields", Toast.LENGTH_SHORT).show()
      }

    },
    modifier = Modifier
      .fillMaxWidth()
      .padding(10.dp),
    shape = RoundedCornerShape(6.dp)
  ) {
    Text(
      text = "Save Event",
      modifier = Modifier
        .padding(6.dp),
    )
  }
}