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
package com.app.composematerialyou.ui.presentation.screens

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.app.composematerialyou.ui.presentation.composables.*
import com.app.composematerialyou.ui.presentation.viewmodels.EventsViewModel


@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@ExperimentalMaterial3Api
@Composable
fun EventScreen(navController: NavController, eventsViewModel: EventsViewModel) {
  Scaffold(
    modifier = Modifier
      .fillMaxSize(),
    topBar = { BackTopBar("Add Event") { navController.popBackStack() } },
    content = {
      EventInputs(eventsViewModel, navController)
    }
  )
}

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@Composable
fun EventInputs(eventsViewModel: EventsViewModel, navController: NavController) {
  val activity = LocalContext.current as AppCompatActivity
  var datePicked by remember { mutableStateOf("") }
  val updatedDate = { date: String? ->
    datePicked = date ?: ""
  }

  Column(
    modifier =
    Modifier
      .fillMaxSize()
      .background(color = MaterialTheme.colorScheme.surfaceVariant)
  ) {
    EventNameInputText("Enter event name", eventsViewModel)
    DatePicker(datePicked, updatedDate, activity, eventsViewModel)
    EventDescriptionInputText("Enter event description", eventsViewModel)
    ColorPicker(eventsViewModel)
    SaveButton(eventsViewModel, navController)
  }
}