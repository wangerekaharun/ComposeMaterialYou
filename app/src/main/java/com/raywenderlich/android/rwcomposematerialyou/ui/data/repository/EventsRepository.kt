package com.raywenderlich.android.rwcomposematerialyou.ui.data.repository

interface EventsRepository {
  suspend fun addEvent()
  suspend fun getAllEvents()
}

class EventsRepositoryImpl: EventsRepository {
  override suspend fun addEvent() {
    TODO("Not yet implemented")
  }

  override suspend fun getAllEvents() {
    TODO("Not yet implemented")
  }

}