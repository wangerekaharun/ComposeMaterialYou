package com.raywenderlich.android.rwcomposematerialyou.ui.theme

import androidx.compose.material.Typography
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
  body1 = TextStyle(
    fontFamily = SourceCodePro,
    fontWeight = FontWeight.Bold,
    fontSize = 16.sp
  ),

  button = TextStyle(
      fontFamily = SourceCodePro,
      fontWeight = FontWeight.W500,
      fontSize = 14.sp
  ),
  caption = TextStyle(
      fontFamily = SourceCodePro,
      fontWeight = FontWeight.Normal,
      fontSize = 12.sp
  )
)