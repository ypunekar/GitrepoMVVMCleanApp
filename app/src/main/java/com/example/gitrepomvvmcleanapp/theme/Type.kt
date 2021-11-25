
package com.example.gitrepomvvmcleanapp.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.gitrepomvvmcleanapp.R

val typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
            h1 = TextStyle(
            fontFamily = FontFamily.Default,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp
)


)
  val fonts = FontFamily(
      Font(R.font.roboto_medium),
      Font(R.font.roboto_bold,weight = FontWeight.Bold),
      Font(R.font.roboto_regular,weight = FontWeight.Normal,style = FontStyle.Normal)
  )

