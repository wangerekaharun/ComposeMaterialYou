package com.raywenderlich.android.rwcomposematerialyou.ui.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "events")
data class UserEvent(
  @PrimaryKey(autoGenerate = true)
  val id: Int = 0,
  val name: String = "",
  val description: String = "",
  val eventColor: String = "",
  val date: String = ""
)
