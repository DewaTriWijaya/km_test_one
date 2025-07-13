package com.dewa.kmtestone.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.dewa.kmtestone.data.viewmodel.UserViewModel
import com.dewa.kmtestone.ui.components.AppBarCustom
import com.dewa.kmtestone.ui.components.CardUserItem
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
        topBar = { AppBarCustom("Third Screen", onClick = { navController.popBackStack() }) }
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
    modifier: Modifier = Modifier,
    viewModel: UserViewModel = viewModel(),
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

@Preview(Devices.PIXEL)
@Composable
private fun PreviewThirdScreen() {
    //ThirdScreen()
}