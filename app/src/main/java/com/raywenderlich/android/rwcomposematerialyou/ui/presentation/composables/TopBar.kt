package com.raywenderlich.android.rwcomposematerialyou.ui.presentation.composables

import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.theme.ComposeMaterialYou

@Composable
fun TopBar(title: String) {
  SmallTopAppBar(title = { Text(title) })
}

@Preview
@Composable
fun TopBarPreview() {
  ComposeMaterialYou {
    TopBar("Compose Material You")
  }
}
