package com.raywenderlich.android.rwcomposematerialyou.ui.presentation.composables

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
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
import com.raywenderlich.android.rwcomposematerialyou.ui.data.models.UserEvent
import com.raywenderlich.android.rwcomposematerialyou.ui.utils.stringToColor

@ExperimentalMaterial3Api
@Composable
fun CalendarListItem(userEvent: UserEvent) {
  var showDescription by remember { mutableStateOf(false) }

  ElevatedCard(
    modifier = Modifier
      .fillMaxWidth()
      .padding(6.dp)
      .clickable {
        showDescription = true
      },
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
            .clickable {
              showDescription = false
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
      if (showDescription) {
        AnimatedVisibility(visible = showDescription) {
          Text(
            text = userEvent.description,
            color = Color.White
          )
          Spacer(
            modifier = Modifier
              .padding(top = 10.dp)
          )
        }
      }
      Text(
        text = userEvent.date,
        color = Color.White
      )
    }
  }
}