package com.raywenderlich.android.rwcomposematerialyou.ui.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BackTopBar(title: String, onBackPressed: (Unit) -> Unit) {
  SmallTopAppBar(
    title = { Text(title) },
    modifier = Modifier.background(color = MaterialTheme.colorScheme.inversePrimary),
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