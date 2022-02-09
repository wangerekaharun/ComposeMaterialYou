package com.raywenderlich.android.rwcomposematerialyou.ui.utils

import androidx.compose.ui.graphics.Color
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.theme.ColorDefaultEvent
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.theme.ColorOther
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.theme.ColorPersonal
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.theme.ColorWork

fun Color.colorToString(): String {
  return when (this) {
    ColorDefaultEvent -> "Default Color"
    ColorWork -> "Work"
    ColorPersonal -> "Personal"
    ColorOther -> "Other"
    else -> "Default Color"
  }
}

fun String.stringToColor(): Color {
  return when (this) {
    "Default Color" -> ColorDefaultEvent
    "Work" -> ColorWork
    "Personal" -> ColorPersonal
    "Other" -> ColorOther
    else -> ColorDefaultEvent
  }
}