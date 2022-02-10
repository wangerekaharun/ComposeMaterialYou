package com.raywenderlich.android.rwcomposematerialyou.ui.presentation.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.raywenderlich.android.rwcomposematerialyou.ui.data.models.UserEvent
import com.raywenderlich.android.rwcomposematerialyou.ui.utils.stringToColor

@ExperimentalMaterial3Api
@Composable
fun CalendarListItem(userEvent: UserEvent) {
  ElevatedCard(
    modifier = Modifier
      .fillMaxWidth()
      .padding(6.dp),
    containerColor = userEvent.eventColor.stringToColor(),
    shape = RoundedCornerShape(15.dp),
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