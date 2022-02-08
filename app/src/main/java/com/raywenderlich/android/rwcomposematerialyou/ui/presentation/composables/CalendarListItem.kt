package com.raywenderlich.android.rwcomposematerialyou.ui.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.theme.ComposeMaterialYou

@Composable
fun CalendarListItem(onEventClicked: (String) -> Unit) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(6.dp)
      .background(color = Color.White, shape = RoundedCornerShape(10.dp))
      .clickable {
                 onEventClicked.invoke("")
      },
  ) {
    Column(modifier = Modifier
      .fillMaxWidth()
      .padding(10.dp)) {
      Text(text = "Compose Material You")
      Spacer(modifier = Modifier
        .padding(top = 10.dp))
      Text(text = "14:00 - 16:00")
    }
  }
}

@Preview
@Composable
fun CalendarListItemPreview() {
  ComposeMaterialYou {
    CalendarListItem {}
  }
}