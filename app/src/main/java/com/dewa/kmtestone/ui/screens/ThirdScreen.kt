package com.dewa.kmtestone.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import com.dewa.kmtestone.data.model.DataUser
import com.dewa.kmtestone.data.viewmodel.UserViewModel
import com.dewa.kmtestone.ui.components.CenterProgress
import com.dewa.kmtestone.ui.components.ErrorFull
import com.dewa.kmtestone.ui.components.ListProgress
import com.dewa.kmtestone.ui.components.RetryFooter

@Composable
fun ThirdScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Scaffold(
        topBar = { AppBarThirdScreen() }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .background(Color.White)
                .padding(innerPadding)
        ) {
            ContentThirdScreen(modifier = modifier, navController = navController)
        }
    }

}

@Composable
fun ContentThirdScreen(
    viewModel: UserViewModel = viewModel(),
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val lazyUsers = viewModel.users.collectAsLazyPagingItems()
    LazyColumn(
        modifier = modifier
            .fillMaxHeight()
            .padding(16.dp)
    ) {
        items(lazyUsers.itemCount) { index ->
            lazyUsers[index]?.let { user ->
                CardUserItem(user) {
                    val fullName = "${user.first_name} ${user.last_name}"
                    navController.navigate("detail/$fullName")
                }
            }
        }

        when (lazyUsers.loadState.append) {
            is LoadState.Loading -> item { ListProgress() }
            is LoadState.Error -> item {
                RetryFooter { lazyUsers.retry() }
            }
            else -> Unit
        }
    }

    when (lazyUsers.loadState.refresh) {
        is LoadState.Loading -> CenterProgress()
        is LoadState.Error -> ErrorFull { lazyUsers.retry() }
        else -> Unit
    }

}

@Composable
private fun CardUserItem(
    user: DataUser,
    onClick: (DataUser) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .clickable { onClick(user) },
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,

            ) {
            AsyncImage(
                model = user.avatar,
                contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
            )
            Spacer(Modifier.width(12.dp))
            Column {
                Text(
                    "${user.first_name} ${user.last_name}",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(user.email, style = MaterialTheme.typography.bodySmall)
            }
        }
        Divider(
            color = Color.Gray,
            thickness = 1.dp
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBarThirdScreen() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "Third Screen",
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        },
        navigationIcon = {
            IconButton(onClick = { }) {
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
private fun PreviewThirdScreen() {
    //ThirdScreen()
}