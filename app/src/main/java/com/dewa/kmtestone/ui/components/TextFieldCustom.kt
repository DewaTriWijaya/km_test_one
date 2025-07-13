package com.dewa.kmtestone.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dewa.kmtestone.R

@Composable
fun TextFieldCustom(
    name: String,
    hint: String,
    onValueChange: (String) -> Unit,
) {
    TextField(
        value = name,
        onValueChange = onValueChange,
        modifier = Modifier
            .fillMaxWidth()
        ,
        textStyle = LocalTextStyle.current.copy(
            color = Color.Black,
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.poppins_medium))
        ),
        placeholder = { Text(hint, color = Color.Gray, fontSize = 14.sp, fontFamily = FontFamily(Font(R.font.poppins_medium))) },
        shape = RoundedCornerShape(12.dp),
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            disabledContainerColor = Color.LightGray,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
    )
}