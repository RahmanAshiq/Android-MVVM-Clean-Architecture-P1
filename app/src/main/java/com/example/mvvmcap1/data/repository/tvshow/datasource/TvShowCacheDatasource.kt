package com.example.mvvmcap1.data.repository.tvshow.datasource

import com.example.mvvmcap1.data.model.tvshow.TvShow

interface TvShowCacheDatasource {
    suspend fun saveTvShowsToCache(tvShows: List<TvShow>)
    suspend fun getTvShowsFromCache(): List<TvShow>
}