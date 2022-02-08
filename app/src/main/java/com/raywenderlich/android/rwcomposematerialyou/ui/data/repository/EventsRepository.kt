package com.raywenderlich.android.rwcomposematerialyou.ui.data.repository

import com.raywenderlich.android.rwcomposematerialyou.ui.data.AppDataBase
import com.raywenderlich.android.rwcomposematerialyou.ui.data.models.Events
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface EventsRepository {
  suspend fun addEvent(events: Events)
  suspend fun getAllEvents(): Flow<List<Events>>
}

class EventsRepositoryImpl(private val appDatabase: AppDataBase): EventsRepository {
  override suspend fun addEvent(events: Events) {
   appDatabase.eventsDao().createEvent(events)
  }

  override suspend fun getAllEvents():Flow<List<Events>> =
    flow {
      appDatabase.eventsDao().getAllEvents()
    }

}