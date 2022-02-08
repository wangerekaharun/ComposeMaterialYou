package com.raywenderlich.android.rwcomposematerialyou.ui.presentation

import androidx.lifecycle.ViewModel
import com.raywenderlich.android.rwcomposematerialyou.ui.data.models.Events
import com.raywenderlich.android.rwcomposematerialyou.ui.data.repository.EventsRepository
import kotlinx.coroutines.flow.Flow

class EventsViewModel(private val eventsRepository: EventsRepository):ViewModel() {

  suspend fun addEvent(events: Events){
    eventsRepository.addEvent(events)
  }

  suspend fun getAllEvents(): Flow<List<Events>> {
    return eventsRepository.getAllEvents()
  }

}