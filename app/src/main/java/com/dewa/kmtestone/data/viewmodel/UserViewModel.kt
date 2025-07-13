package com.dewa.kmtestone.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.dewa.kmtestone.data.datasource.UserRepository

class UserViewModel(
    repo: UserRepository = UserRepository()
) : ViewModel() {

    val users = repo.getUsersStream()
        .cachedIn(viewModelScope)
}
