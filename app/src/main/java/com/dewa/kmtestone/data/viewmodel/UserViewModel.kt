package com.dewa.kmtestone.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.dewa.kmtestone.data.datasource.UserRepository

class UserViewModel(
    repository: UserRepository = UserRepository()
) : ViewModel() {

    val users = repository.getUsersStream()
        .cachedIn(viewModelScope)

}
