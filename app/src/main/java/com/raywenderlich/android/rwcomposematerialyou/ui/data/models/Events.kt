package com.raywenderlich.android.rwcomposematerialyou.ui.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "events")
data class Events(
  @PrimaryKey(autoGenerate = true)
  val id: Int = 0,
  val name: String,
  val description: String,
  val color: String,
  val date: String
)
