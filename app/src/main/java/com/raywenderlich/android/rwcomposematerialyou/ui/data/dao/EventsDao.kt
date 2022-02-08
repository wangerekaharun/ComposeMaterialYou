package com.raywenderlich.android.rwcomposematerialyou.ui.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.raywenderlich.android.rwcomposematerialyou.ui.data.models.Events
import kotlinx.coroutines.flow.Flow

@Dao
interface EventsDao {

  @Insert(onConflict = REPLACE)
  suspend fun createEvent(events: Events)

  @Query("SELECT * FROM events")
  suspend fun getAllEvents(): Flow<List<Events>>
}