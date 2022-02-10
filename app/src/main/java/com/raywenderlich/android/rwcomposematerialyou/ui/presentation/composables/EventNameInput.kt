package com.raywenderlich.android.rwcomposematerialyou.ui.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.viewmodels.EventsViewModel

@ExperimentalComposeUiApi
@Composable
fun EventNameInputText(label: String, eventsViewModel: EventsViewModel) {
  var userInput by remember { mutableStateOf("") }
  val (nameInput) = FocusRequester.createRefs()
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(10.dp)
  ) {
    Text(
      text = label,
      modifier = Modifier
        .fillMaxWidth()
        .padding(6.dp)
    )
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
    ) {
      BasicTextField(
        modifier = Modifier
          .padding(16.dp)
          .focusRequester(nameInput),
        keyboardActions = KeyboardActions(
          onNext = {
            nameInput.requestFocus()
          }
        ),

        onValueChange = {
          userInput = it
          eventsViewModel.eventName = userInput
        },
        value = userInput,
      )
    }
  }
}