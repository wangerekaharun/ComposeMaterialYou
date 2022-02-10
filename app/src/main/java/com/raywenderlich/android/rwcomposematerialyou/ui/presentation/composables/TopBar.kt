package com.raywenderlich.android.rwcomposematerialyou.ui.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.theme.ComposeMaterialYou

@Composable
fun TopBar(title: String) {
  SmallTopAppBar(
    title = { Text(title) },
    modifier = Modifier
      .background(color = MaterialTheme.colorScheme.inversePrimary)
  )
}

@Preview
@Composable
fun TopBarPreview() {
  ComposeMaterialYou {
    TopBar("Compose Material You")
  }
}
