/*
 * Copyright (c) 2021 Razeware LLC
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

package com.raywenderlich.android.rwcomposematerialyou.ui.presentation.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.composables.CalendarListItem
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.composables.TopBar
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.navigation.AppNavigation
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.navigation.Screens
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.theme.ComposeMaterialYou

@ExperimentalMaterial3Api
class HomeActivityScreen : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      val navController = rememberNavController()
      ComposeMaterialYou {
        AppNavigation(navController)
      }
    }
  }
}

@ExperimentalMaterial3Api
@Composable
fun HomeScreen(navController: NavController) {
  Scaffold(
    modifier = Modifier.fillMaxSize(),
    topBar = { TopBar("Compose Material You") },
    content = {
     EventList {
       navController.navigate(Screens.EventDetails.route)
     }
    },
    floatingActionButton = {
      ExtendedFloatingActionButton(
        modifier = Modifier
          .padding(16.dp),
        onClick = {
                  navController.navigate(Screens.EventInputScreen.route)
        },
        icon = {
          Icon(
            Icons.Filled.Add,
            contentDescription = "Create"
          )
        },
        text = { Text("Create") }
      )
    }
  )
}

@Composable
fun EventList(onEventClicked: (String) -> Unit) {
 LazyColumn( modifier = Modifier
   .fillMaxSize()
   .background(Color.LightGray)
 ) {
   val list = listOf("1","2", "3", "4", "5", "6", "7", "8", "9")
   items(list) {
     CalendarListItem(onEventClicked)
   }
 }
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  ComposeMaterialYou {

  }
}