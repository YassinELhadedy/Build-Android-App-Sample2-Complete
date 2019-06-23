package com.completesample2.githubrepos.kotlin.db

import android.arch.lifecycle.LiveData
import android.arch.paging.DataSource
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.completesample2.githubrepos.kotlin.model.User

/**
 *
 * Room data access object for accessing the [User] table.
 */
@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(posts: List<User>)

    // Do a similar query as the search API:
    // Look for users that contain the query string in the User Name.
    @Query("SELECT * FROM user WHERE (login LIKE :queryString)")
    fun usersByName(queryString: String): DataSource.Factory<Int, User>

    // Do a similar query as the search API:
    // Look for users that contain the query string in the User Id.
    @Query("SELECT * FROM user WHERE (id LIKE :userId)")
    fun userById(userId: Long): LiveData<User>

}