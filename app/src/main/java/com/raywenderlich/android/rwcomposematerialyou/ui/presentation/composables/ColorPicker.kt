package com.raywenderlich.android.rwcomposematerialyou.ui.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.theme.ComposeMaterialYou

@Composable
fun ColorPicker() {
  Row(modifier = Modifier
    .fillMaxWidth()
    .background(White)
    .border(0.5.dp, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f))
  ) {
    Box(
      modifier = Modifier
        .size(40.dp)
        .padding( 10.dp)
        .clip(shape = RoundedCornerShape(25.dp))
        .background(Green)
    )

    Text(
      text = "Default Color",
      textAlign = TextAlign.Center,
      modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)
        .align(alignment = Alignment.CenterVertically)
    )
  }
}


@Preview
@Composable
fun ColorPickerPreview() {
  ComposeMaterialYou {
    ColorPicker()
  }
}