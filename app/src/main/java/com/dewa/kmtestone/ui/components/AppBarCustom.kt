package com.dewa.kmtestone.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dewa.kmtestone.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarCustom(
    nameBar: String,
    navController: NavController
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = nameBar,
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.poppins_semi_bold))
            )
        },
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "back",
                    tint = Color(0xFF554AF0),
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.White
        ),
        modifier = Modifier.shadow(1.dp)
    )
}