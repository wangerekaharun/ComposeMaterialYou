package com.raywenderlich.android.rwcomposematerialyou.ui.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.raywenderlich.android.rwcomposematerialyou.ui.data.models.UserEvent
import com.raywenderlich.android.rwcomposematerialyou.ui.data.repository.EventsRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class EventsViewModel(private val eventsRepository: EventsRepository) : ViewModel() {
  private val _events = MutableLiveData<List<UserEvent>>()
  val userEvent: MutableLiveData<List<UserEvent>> get() = _events
  var userSelectedColor = ""
  var eventName = ""
  var eventDescription = ""
  var date = ""

  fun addEvent() {
    viewModelScope.launch {
      eventsRepository.addEvent(
        UserEvent(
          0,
          eventName,
          eventDescription,
          userSelectedColor,
          date
        )
      )
    }
  }

  fun getAllEvents() {
    viewModelScope.launch {
      eventsRepository.getAllEvents().collect {
        _events.value = it
      }
    }
  }
}