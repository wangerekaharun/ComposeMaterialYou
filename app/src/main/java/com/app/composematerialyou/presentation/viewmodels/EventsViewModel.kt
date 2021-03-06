/*
 * Copyright (c) 2022 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * This project and source code may use libraries or frameworks that are
 * released under various Open-Source licenses. Use of those libraries and
 * frameworks are governed by their own individual licenses.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.app.composematerialyou.presentation.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.composematerialyou.data.models.UserEvent
import com.app.composematerialyou.data.repository.EventsRepository
import kotlinx.coroutines.launch

class EventsViewModel(private val eventsRepository: EventsRepository) : ViewModel() {
  private val _events = MutableLiveData<List<UserEvent>>()
  val userEvent: MutableLiveData<List<UserEvent>> get() = _events
  var userSelectedColor = "Default Color"
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

  fun validate(): Boolean =
    eventName.isNotEmpty() && eventDescription.isNotEmpty() && date.isNotEmpty()

}