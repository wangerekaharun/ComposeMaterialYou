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
package com.app.composematerialyou.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import com.app.composematerialyou.data.models.EventColors
import com.app.composematerialyou.presentation.viewmodels.EventsViewModel

@Composable
fun ColorPicker(eventsViewModel: EventsViewModel) {
  var showDialog by remember { mutableStateOf(false) }
  var colorSelected by remember {
    mutableStateOf(EventColors(Green, "Default Color"))
  }

  // TODO Add Alert Dialog with Fade Animations

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(10.dp)
      .background(color = White, shape = RoundedCornerShape(10.dp))
      .clickable(
        indication = rememberRipple(bounded = true),
        interactionSource = remember {
          MutableInteractionSource()
        }
      ) {
        showDialog = true
      }
  ) {
    Spacer(
      modifier = Modifier
        .padding(top = 10.dp)
    )
    Row(
      modifier = Modifier
        .fillMaxWidth()
    ) {
      Box(
        modifier = Modifier
          .size(40.dp)
          .padding(10.dp)
          .clip(shape = RoundedCornerShape(25.dp))
          .background(colorSelected.color)
      )

      Text(
        text = colorSelected.name,
        modifier = Modifier
          .fillMaxWidth()
          .padding(10.dp)
          .align(alignment = Alignment.CenterVertically)
      )
    }
    Spacer(
      modifier = Modifier
        .padding(top = 10.dp)
    )

  }
}
