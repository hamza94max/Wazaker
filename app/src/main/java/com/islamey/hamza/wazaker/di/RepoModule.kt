package com.islamey.hamza.wazaker.di

import com.islamey.hamza.wazaker.data.remote.ApiService
import com.islamey.hamza.wazaker.data.repoImpl.HijriRepoImpl
import com.islamey.hamza.wazaker.domain.repo.HijriRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {


    @Provides
    fun provideHijriRepo(apiService: ApiService): HijriRepo {
        return HijriRepoImpl(apiService)
    }


}