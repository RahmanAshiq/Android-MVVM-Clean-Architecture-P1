package com.example.mvvmcap1.data.repository.tvshow.datasource

import com.example.mvvmcap1.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDatasource {
    suspend fun getTvShowsFromRemoteApi(): Response<TvShowList>
}