package com.raywenderlich.android.rwcomposematerialyou.ui.composables

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.raywenderlich.android.rwcomposematerialyou.ui.theme.ComposeMaterialYou

@Composable
fun TopBar() {
  TopAppBar(title = { Text("Compose Material You") })
}

@Preview
@Composable
fun TopBarPreview() {
  ComposeMaterialYou {
    TopBar()
  }
}
