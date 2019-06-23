package com.completesample2.githubrepos.kotlin

import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import com.completesample2.githubrepos.kotlin.api.GithubService
import com.completesample2.githubrepos.kotlin.data.GithubRepository
import com.completesample2.githubrepos.kotlin.db.GithubLocalCache
import com.completesample2.githubrepos.kotlin.db.RepoDatabase
import com.completesample2.githubrepos.kotlin.ui.ViewModelFactory
import java.util.concurrent.Executors

/**
 *
 * Class that handles object creation.
 * Like this, objects can be passed as parameters in the constructors and then replaced for
 * testing, where needed.
 */
object Injection {

    const val USER_ID = "user_id"

    /**
     * Creates an instance of [GithubLocalCache] based on the database DAO.
     */
    private fun provideCache(context: Context): GithubLocalCache {
        val database = RepoDatabase.getInstance(context)
        return GithubLocalCache(database.usersDao(), Executors.newSingleThreadExecutor())
    }

    /**
     * Creates an instance of [GithubRepository] based on the [GithubService] and a
     * [GithubLocalCache]
     */
    private fun provideGithubRepository(context: Context): GithubRepository {
        return GithubRepository(GithubService.create(), provideCache(context))
    }

    /**
     * Provides the [ViewModelProvider.Factory] that is then used to get a reference to
     * [ViewModel] objects.
     */
    fun provideViewModelFactory(context: Context): ViewModelProvider.Factory {
        return ViewModelFactory(provideGithubRepository(context))
    }

}