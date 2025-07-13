package com.dewa.kmtestone.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dewa.kmtestone.R
import com.dewa.kmtestone.ui.components.ButtonCustom
import com.dewa.kmtestone.ui.components.TextFieldCustom
import com.dewa.kmtestone.utils.Utils.isPalindrome

@Composable
fun FirstScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var name by remember { mutableStateOf("") }
    var palindrome by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(40.dp, alignment = Alignment.CenterVertically),
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .paint(
                painterResource(id = R.drawable.background),
                contentScale = ContentScale.FillBounds
            )
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_photo),
            contentDescription = "",
            modifier = Modifier
                .width(116.dp)
                .height(116.dp)
        )

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            TextFieldCustom(name, "Name", onValueChange = { name = it })
            TextFieldCustom(palindrome, "Palindrome", onValueChange = { palindrome = it })
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            ButtonCustom("CHECK"){
                val message = if (palindrome.isBlank()) {
                    "Fill in the palindrome column first"
                } else if (isPalindrome(palindrome)) {
                    "isPalindrome"
                } else {
                    "not palindrome"
                }
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            }
            ButtonCustom("NEXT"){
                if (name.isBlank()) {
                    Toast.makeText(context, "Name Not Empty", Toast.LENGTH_SHORT).show()
                } else {
                    navController.navigate("second/$name")
                }
            }
        }
    }
}

@Preview(Devices.PIXEL)
@Composable
private fun PreviewFirstScreen() {
    //FirstScreen()
}