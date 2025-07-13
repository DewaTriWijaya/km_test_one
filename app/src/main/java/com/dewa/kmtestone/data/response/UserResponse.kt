package com.dewa.kmtestone.data.response

import com.dewa.kmtestone.data.model.DataUser

data class UserResponse(
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int,
    val data: List<DataUser>,
)