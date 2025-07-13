package com.dewa.kmtestone.data.network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.dewa.kmtestone.data.model.DataUser

class UserPagingSource(
    private val api: ApiService
) : PagingSource<Int, DataUser>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, DataUser> {
        return try {
            val page = params.key ?: 1
            val resp = api.getUsers(page)
            LoadResult.Page(
                data = resp.data,
                prevKey = if (page == 1) null else page - 1,
                nextKey = if (page < resp.total_pages) page + 1 else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, DataUser>): Int? =
        state.anchorPosition?.let { anchor ->
            state.closestPageToPosition(anchor)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchor)?.nextKey?.minus(1)
        }
}
