package com.dewa.kmtestone.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dewa.kmtestone.ui.components.ButtonCustom

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecondScreen(
    name: String,
    username: String = "Selected User Name",
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Scaffold(
        topBar = { AppBarSecondScreen(navController) }
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
            Text("Welcome")
            Text(name)
        }

        Text(
            text = username,
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
        )

        ButtonCustom("Choose a User"){
            navController.navigate("third")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarSecondScreen(
    navController: NavController
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "Second Screen",
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        },
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() } ) {
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
        )
    )
}


@Preview(Devices.PIXEL)
@Composable
private fun PreviewSecondScreen() {
    //SecondScreen("Dewa")
}