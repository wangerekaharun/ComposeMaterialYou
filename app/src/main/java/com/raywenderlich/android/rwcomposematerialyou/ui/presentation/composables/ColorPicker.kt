package com.raywenderlich.android.rwcomposematerialyou.ui.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raywenderlich.android.rwcomposematerialyou.ui.data.models.EventColors
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.viewmodels.EventsViewModel
import com.raywenderlich.android.rwcomposematerialyou.ui.utils.colorToString
import com.raywenderlich.android.rwcomposematerialyou.ui.utils.eventColors

@Composable
fun ColorPicker(eventsViewModel: EventsViewModel) {
  var showDialog by remember { mutableStateOf(false) }
  var colorSelected by remember {
    mutableStateOf(EventColors(Green, "Default Color"))
  }

  if (showDialog) {
    AlertDialog(
      onDismissRequest = { },
      title = { Text(text = "Select Color") },
      text = {
        LazyColumn(
          content = {
            items(eventColors) { eventColor ->
              Row(
                modifier = Modifier
                  .fillMaxWidth()
                  .clickable {
                    showDialog = false
                    colorSelected = eventColor
                    eventsViewModel.userSelectedColor = colorSelected.color.colorToString()
                  }
              ) {
                Box(
                  modifier = Modifier
                    .size(25.dp)
                    .padding(5.dp)
                    .align(alignment = Alignment.CenterVertically)
                    .clip(shape = RoundedCornerShape(15.dp))
                    .background(eventColor.color)
                )

                Text(
                  text = eventColor.name,
                  modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .align(alignment = Alignment.CenterVertically),
                  fontSize = 12.sp
                )
              }
            }
          }
        )
      },
      confirmButton = { },
      dismissButton = { },
    )
  }

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(10.dp)
      .background(color = White, shape = RoundedCornerShape(10.dp))
      .clickable {
        showDialog = true
      }
  ) {
    Spacer(
      modifier = Modifier
        .padding(top = 10.dp)
    )
    Row(
      modifier = Modifier
        .fillMaxWidth()
    ) {
      Box(
        modifier = Modifier
          .size(40.dp)
          .padding(10.dp)
          .clip(shape = RoundedCornerShape(25.dp))
          .background(colorSelected.color)
      )

      Text(
        text = colorSelected.name,
        modifier = Modifier
          .fillMaxWidth()
          .padding(10.dp)
          .align(alignment = Alignment.CenterVertically)
      )
    }
    Spacer(
      modifier = Modifier
        .padding(top = 10.dp)
    )

  }
}
