package com.raywenderlich.android.rwcomposematerialyou.ui.presentation.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension.Companion.fillToConstraints

@Composable
fun DatePicker() {
  //val activity = LocalContext.current as AppCompatActivity

  Box(
    modifier = Modifier
      .fillMaxWidth()
      .wrapContentSize(Alignment.TopStart)
      .padding(top = 10.dp)
      .border(0.5.dp, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f))
      .clickable{

      }
  ) {

    ConstraintLayout(
      modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
    ) {

      val (lable, iconView) = createRefs()

      Text(
        text= "Date Picker",
        color = MaterialTheme.colorScheme.onSurface,
        modifier = Modifier
          .fillMaxWidth()
          .constrainAs(lable) {
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