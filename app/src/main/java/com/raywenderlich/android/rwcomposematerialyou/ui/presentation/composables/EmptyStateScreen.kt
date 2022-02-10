package com.raywenderlich.android.rwcomposematerialyou.ui.presentation.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EmptyStateScreen() {
  Column(
    modifier = Modifier
      .fillMaxHeight()
      .fillMaxWidth(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {

    Icon(
      imageVector = Icons.Default.DateRange,
      contentDescription = null,
      modifier = Modifier
        .size(60.dp, 60.dp),
      tint = MaterialTheme.colorScheme.onSurface
    )

    Spacer(
      modifier = Modifier
        .padding(top = 30.dp)
    )

    Text(
      text = "No events created",
      modifier = Modifier
        .fillMaxWidth(),
      color = Color.Black,
      textAlign = TextAlign.Center,
      fontSize = 24.sp,
      fontWeight = FontWeight.Bold
    )
  }
}