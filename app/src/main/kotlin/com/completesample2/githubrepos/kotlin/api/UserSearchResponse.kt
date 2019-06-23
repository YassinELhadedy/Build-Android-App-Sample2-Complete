package com.completesample2.githubrepos.kotlin.api

import com.completesample2.githubrepos.kotlin.model.User
import com.google.gson.annotations.SerializedName

/**
 *
 * Data class to hold user responses from searchUser API calls.
 */
data class UserSearchResponse(
        @SerializedName("total_count") val total: Int = 0,
        @SerializedName("items") val items: List<User> = emptyList(),
        val nextPage: Int? = null
)