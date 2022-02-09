package com.raywenderlich.android.rwcomposematerialyou.ui.utils

import java.text.SimpleDateFormat
import java.util.*

fun Long?.toDateString() : String?{
  this?.let{
    val formatter = SimpleDateFormat("dd-MM-yyyy", Locale.US)
    val calendar: Calendar = Calendar.getInstance()
    calendar.timeInMillis = it
    return formatter.format(calendar.time)
  }
  return null
}