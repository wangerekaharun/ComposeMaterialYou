package com.raywenderlich.android.rwcomposematerialyou.ui.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.raywenderlich.android.rwcomposematerialyou.ui.data.dao.EventsDao
import com.raywenderlich.android.rwcomposematerialyou.ui.data.models.UserEvent

@Database(
  entities = [UserEvent::class],
  version = 1,
  exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {
  abstract fun eventsDao(): EventsDao

}