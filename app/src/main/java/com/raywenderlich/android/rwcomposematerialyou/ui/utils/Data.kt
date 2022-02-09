package com.raywenderlich.android.rwcomposematerialyou.ui.utils

import com.raywenderlich.android.rwcomposematerialyou.ui.data.models.EventColors
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.theme.ColorDefaultEvent
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.theme.ColorOther
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.theme.ColorPersonal
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.theme.ColorWork

val eventColors = listOf(
  EventColors(ColorDefaultEvent, "Default Color"),
  EventColors(ColorWork, "Work"),
  EventColors(ColorPersonal, "Personal"),
  EventColors(ColorOther, "Other")
)