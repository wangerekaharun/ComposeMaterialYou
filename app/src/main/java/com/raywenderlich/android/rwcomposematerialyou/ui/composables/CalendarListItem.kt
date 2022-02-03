package com.raywenderlich.android.rwcomposematerialyou.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raywenderlich.android.rwcomposematerialyou.ui.theme.ComposeMaterialYou

@Composable
fun CalendarListItem() {
  Card(
    modifier = Modifier
      .fillMaxWidth()
      .padding(6.dp)
      .clickable { },
    elevation = 8.dp
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
    CalendarListItem()
  }
}