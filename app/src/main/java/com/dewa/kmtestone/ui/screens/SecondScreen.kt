package com.dewa.kmtestone.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dewa.kmtestone.R
import com.dewa.kmtestone.ui.components.AppBarCustom
import com.dewa.kmtestone.ui.components.ButtonCustom

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondScreen(
    modifier: Modifier = Modifier,
    name: String,
    username: String = "Selected User Name",
    navController: NavController
) {
    Scaffold(
        topBar = { AppBarCustom("Second Screen", navController) }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(Color.White)
                .padding(innerPadding)
        ) {
            ContentSecondScreen(name, username, modifier, navController)
        }
    }
}

@Composable
fun ContentSecondScreen(
    name: String,
    username: String,
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxHeight()
            .padding(16.dp)
    ) {
        Column {
            Text(
                text = "Welcome",
                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                color = Color.Black
            )
            Text(
                text = name,
                fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
                color = Color.Black,
                fontSize = 24.sp
            )
        }

        Text(
            text = username,
            textAlign = TextAlign.Center,
            color = Color.Black,
            fontFamily = FontFamily(Font(R.font.poppins_semi_bold)),
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
        )

        ButtonCustom("Choose a User") {
            navController.navigate("third")
        }
    }
}


@Preview(Devices.PIXEL)
@Composable
private fun PreviewSecondScreen() {
    //SecondScreen("Dewa")
}