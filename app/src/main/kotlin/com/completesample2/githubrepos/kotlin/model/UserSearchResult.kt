package com.completesample2.githubrepos.kotlin.model

import android.arch.lifecycle.LiveData
import android.arch.paging.PagedList
import com.completesample2.githubrepos.kotlin.data.NetworkState

/**
 *
 * UserSearchResult from a search, which contains LiveData<List<User>> holding query data,
 * and a LiveData<NetworkState> of network status.
 */
data class UserSearchResult(
    val data: LiveData<PagedList<User>>,
    val networkState: LiveData<NetworkState>
)