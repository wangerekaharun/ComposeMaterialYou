package com.raywenderlich.android.rwcomposematerialyou.ui.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raywenderlich.android.rwcomposematerialyou.ui.data.models.Events
import com.raywenderlich.android.rwcomposematerialyou.ui.data.repository.EventsRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class EventsViewModel(private val eventsRepository: EventsRepository):ViewModel() {
  private val _events = MutableSharedFlow<List<Events>>()
  val events:SharedFlow<List<Events>> get() = _events

  fun addEvent(events: Events){
   viewModelScope.launch {
     eventsRepository.addEvent(events)
   }
  }

  fun getAllEvents(){
    viewModelScope.launch {
      eventsRepository.getAllEvents().collect {
        _events.tryEmit(it)
      }
    }
  }

}