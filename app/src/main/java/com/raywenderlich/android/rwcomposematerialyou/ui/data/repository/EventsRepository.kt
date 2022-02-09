package com.raywenderlich.android.rwcomposematerialyou.ui.data.repository

import com.raywenderlich.android.rwcomposematerialyou.ui.data.AppDataBase
import com.raywenderlich.android.rwcomposematerialyou.ui.data.models.UserEvent
import kotlinx.coroutines.flow.Flow

interface EventsRepository {
  suspend fun addEvent(userEvent: UserEvent)
  suspend fun getAllEvents(): Flow<List<UserEvent>>
}

class EventsRepositoryImpl(private val appDatabase: AppDataBase) : EventsRepository {
  override suspend fun addEvent(userEvent: UserEvent) {
    appDatabase.eventsDao().createEvent(userEvent)
  }

  override suspend fun getAllEvents(): Flow<List<UserEvent>> =
    appDatabase.eventsDao().getAllEvents()
}