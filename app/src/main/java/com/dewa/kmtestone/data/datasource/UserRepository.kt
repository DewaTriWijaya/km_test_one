package com.dewa.kmtestone.data.datasource

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.dewa.kmtestone.data.model.DataUser
import com.dewa.kmtestone.data.network.ApiService
import com.dewa.kmtestone.data.network.NetworkModule
import com.dewa.kmtestone.data.network.UserPagingSource
import kotlinx.coroutines.flow.Flow

class UserRepository(
    private val api: ApiService = NetworkModule.retrofit.create(ApiService::class.java)
) {
    fun getUsersStream(): Flow<PagingData<DataUser>> =
        Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { UserPagingSource(api) }
        ).flow
}
