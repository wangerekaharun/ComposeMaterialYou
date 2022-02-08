package com.raywenderlich.android.rwcomposematerialyou.ui.presentation.composables

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun BackTopBar(title: String, onBackPressed: (Unit) ->Unit) {
  SmallTopAppBar(
    title = { Text(title) },
    navigationIcon = {
      IconButton(onClick = {
        onBackPressed.invoke(Unit)
      }) {
        Icon(
          imageVector = Icons.Default.ArrowBack,
          contentDescription = "Back Icon",
        )
      }
    }
  )
}