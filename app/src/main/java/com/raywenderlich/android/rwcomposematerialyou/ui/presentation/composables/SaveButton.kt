package com.raywenderlich.android.rwcomposematerialyou.ui.presentation.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SaveButton() {
  ElevatedButton(onClick = { /*TODO*/ },
    modifier = Modifier.fillMaxWidth()
  ) {
    Text(text = "Save Event")
  }
}