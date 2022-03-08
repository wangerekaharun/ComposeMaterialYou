package com.raywenderlich.android.rwcomposematerialyou.ui.presentation.screens

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.raywenderlich.android.rwcomposematerialyou.ui.data.models.UserEvent
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.composables.CalendarListItem
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.composables.EmptyStateScreen
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.composables.TopBar
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.navigation.AppNavigation
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.navigation.Screens
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.theme.ComposeMaterialYou
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.viewmodels.EventsViewModel
import org.koin.android.ext.android.inject

@ExperimentalAnimationApi
@ExperimentalComposeUiApi
@ExperimentalMaterial3Api
class HomeActivityScreen : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      val navController = rememberAnimatedNavController()
      val eventsViewModel: EventsViewModel by inject()
      ComposeMaterialYou {
        AppNavigation(navController, eventsViewModel)
      }
    }
  }
}

@ExperimentalMaterial3Api
@Composable
fun HomeScreen(navController: NavController, eventsViewModel: EventsViewModel) {
  eventsViewModel.getAllEvents()
  Scaffold(
    modifier = Modifier.fillMaxSize(),
    topBar = { TopBar("Compose Material You") },
    content = {
      val events by eventsViewModel.userEvent.observeAsState()
      if (events.isNullOrEmpty()) {
        EmptyStateScreen()
      } else {
        events?.let { userEvents ->
          EventList(events = userEvents)
        }
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

@ExperimentalMaterial3Api
@Composable
fun EventList(events: List<UserEvent>) {
  LazyColumn(
    modifier = Modifier
      .fillMaxSize()
      .background(MaterialTheme.colorScheme.onPrimary)
  ) {
    items(events) { userEvent ->
      CalendarListItem(userEvent)
    }
  }
}
