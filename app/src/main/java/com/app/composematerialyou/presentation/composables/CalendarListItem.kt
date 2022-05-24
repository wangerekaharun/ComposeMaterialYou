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

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.app.composematerialyou.data.models.UserEvent
import com.app.composematerialyou.utils.stringToColor

@ExperimentalMaterial3Api
@Composable
fun CalendarListItem(userEvent: UserEvent) {
  var showDescription by remember { mutableStateOf(false) }

  ElevatedCard(
    modifier = Modifier
      .fillMaxWidth()
      .padding(6.dp),
    containerColor = userEvent.eventColor.stringToColor(),
    shape = RoundedCornerShape(15.dp),
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp)
    ) {
      ConstraintLayout(
        modifier = Modifier
          .fillMaxWidth()
      ) {
        val (tvName, icon) = createRefs()
        Text(
          text = userEvent.name,
          modifier = Modifier
            .constrainAs(tvName) {
              top.linkTo(parent.top)
              bottom.linkTo(parent.bottom)
              start.linkTo(parent.start)
            },
          color = Color.White,
          fontSize = 20.sp,
          fontWeight = FontWeight.Bold
        )
        Icon(
          imageVector = if (showDescription) Icons.Default.KeyboardArrowUp else
            Icons.Default.KeyboardArrowDown,
          contentDescription = null,
          modifier = Modifier
            .size(30.dp, 30.dp)
            .clickable(
              indication = rememberRipple(bounded = true),
              interactionSource = remember {
                MutableInteractionSource()
              }
            ) {
              showDescription = !showDescription
            }
            .constrainAs(icon) {
              top.linkTo(parent.top)
              bottom.linkTo(parent.bottom)
              end.linkTo(parent.end)
            },
          tint = Color.White,
        )
      }
      Spacer(
        modifier = Modifier
          .padding(top = 10.dp)
      )

      // TODO Add Animated Visibility Animation

      Text(
        text = userEvent.date,
        color = Color.White
      )
    }
  }
}