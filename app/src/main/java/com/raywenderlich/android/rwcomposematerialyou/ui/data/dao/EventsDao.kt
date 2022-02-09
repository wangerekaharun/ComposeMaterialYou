package com.raywenderlich.android.rwcomposematerialyou.ui.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.raywenderlich.android.rwcomposematerialyou.ui.data.models.UserEvent
import kotlinx.coroutines.flow.Flow

@Dao
interface EventsDao {

  @Insert(onConflict = REPLACE)
  suspend fun createEvent(userEvent: UserEvent)

  @Query("SELECT * FROM events")
  fun getAllEvents(): Flow<List<UserEvent>>
}