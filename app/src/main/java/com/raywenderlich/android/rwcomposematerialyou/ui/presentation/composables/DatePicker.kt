package com.raywenderlich.android.rwcomposematerialyou.ui.presentation.composables

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension.Companion.fillToConstraints
import com.raywenderlich.android.rwcomposematerialyou.ui.presentation.viewmodels.EventsViewModel
import com.raywenderlich.android.rwcomposematerialyou.ui.utils.showDatePicker

@Composable
fun DatePicker(
  datePicked: String?,
  updatedDate: (date: String?) -> Unit,
  activity: AppCompatActivity,
  eventsViewModel: EventsViewModel
) {
  Box(
    modifier = Modifier
      .fillMaxWidth()
      .wrapContentSize(Alignment.TopStart)
      .padding(10.dp)
      .background(color = Color.White, shape = RoundedCornerShape(10.dp))
      .clickable {
        showDatePicker(
          activity,
          updatedDate
        )
      }
  ) {

    eventsViewModel.date = datePicked.toString()

    ConstraintLayout(
      modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
    ) {

      val (label, iconView) = createRefs()

      val showLabel = if (datePicked.isNullOrEmpty()) "Choose a Date" else datePicked

      Text(
        text = showLabel,
        color = MaterialTheme.colorScheme.onSurface,
        modifier = Modifier
          .fillMaxWidth()
          .constrainAs(label) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(iconView.start)
            width = fillToConstraints
          }
      )

      Icon(
        imageVector = Icons.Default.DateRange,
        contentDescription = null,
        modifier = Modifier
          .size(20.dp, 20.dp)
          .constrainAs(iconView) {
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
          },
        tint = MaterialTheme.colorScheme.onSurface
      )

    }

  }
}