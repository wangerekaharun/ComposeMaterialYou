package com.raywenderlich.android.rwcomposematerialyou.ui.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.raywenderlich.android.rwcomposematerialyou.ui.data.models.UserEvent
import com.raywenderlich.android.rwcomposematerialyou.ui.utils.stringToColor

@Composable
fun CalendarListItem(userEvent: UserEvent, onEventClicked: (String) -> Unit) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(6.dp)
      .background(color = userEvent.eventColor.stringToColor(), shape = RoundedCornerShape(15.dp))
      .clickable {
        onEventClicked.invoke("")
      },
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)
    ) {
      Text(text = userEvent.name)
      Spacer(
        modifier = Modifier
          .padding(top = 10.dp)
      )
      Text(text = userEvent.date)
    }
  }
}