package com.example.mvvmcap1.data.repository.tvshow.datasourceimpl

import com.example.mvvmcap1.data.api.TMDBService
import com.example.mvvmcap1.data.model.tvshow.TvShowList
import com.example.mvvmcap1.data.repository.tvshow.datasource.TvShowRemoteDatasource
import retrofit2.Response

class TvShowRemoteDatasourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String,
): TvShowRemoteDatasource {
    override suspend fun getTvShowsFromRemoteApi() = tmdbService.getPopularTvShows(apiKey = apiKey)
}