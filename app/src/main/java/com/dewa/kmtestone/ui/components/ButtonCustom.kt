package com.dewa.kmtestone.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ButtonCustom(name: String, onClick: () -> Unit,) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(41.dp)
        ,
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF2B637B),
            contentColor = Color.White
        )
    ) {
        Text(name)
    }
}