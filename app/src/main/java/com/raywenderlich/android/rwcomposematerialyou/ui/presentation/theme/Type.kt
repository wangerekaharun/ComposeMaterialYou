package com.raywenderlich.android.rwcomposematerialyou.ui.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.raywenderlich.android.rwcomposematerialyou.R

val SourceCodePro = FontFamily(
  Font(R.font.sourcecodeproregular)
)

val Typography = Typography(
  displayLarge = TextStyle(
    fontFamily = SourceCodePro,
    fontWeight = FontWeight.Bold,
    fontSize = 16.sp
  ),

  displayMedium = TextStyle(
      fontFamily = SourceCodePro,
      fontWeight = FontWeight.W500,
      fontSize = 14.sp
  ),
  labelSmall = TextStyle(
      fontFamily = SourceCodePro,
      fontWeight = FontWeight.Normal,
      fontSize = 12.sp
  )
)