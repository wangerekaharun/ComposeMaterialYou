package com.raywenderlich.android.rwcomposematerialyou.ui.presentation.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun EventInputText(label: String) {
  Box(
    modifier = Modifier
    .fillMaxWidth()
    .border(0.5.dp, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)),) {
    BasicTextField(
      modifier = Modifier
        .padding(16.dp),

      onValueChange = {
      },
      value = label,
    )
  }

}