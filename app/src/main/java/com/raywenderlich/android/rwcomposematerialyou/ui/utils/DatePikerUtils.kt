package com.raywenderlich.android.rwcomposematerialyou.ui.utils

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
import java.util.*

fun showDatePicker(
  activity: AppCompatActivity,
  updatedDate: (String) -> Unit
) {
  val c = Calendar.getInstance()
  val calendarYear = c.get(Calendar.YEAR)
  val calendarMonth = c.get(Calendar.MONTH)
  val calendarDay = c.get(Calendar.DAY_OF_MONTH)
  val datePickerDialog = DatePickerDialog(
    activity, { _: DatePicker, year: Int, month: Int, day: Int ->
      updatedDate("$day-${month + 1}-$year")
    }, calendarYear, calendarMonth, calendarDay
  )
  datePickerDialog.show()
}