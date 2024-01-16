package com.example.mvvmcap1.data.repository.tvshow.datasourceimpl

import com.example.mvvmcap1.data.model.tvshow.TvShow
import com.example.mvvmcap1.data.repository.tvshow.datasource.TvShowCacheDatasource

class TvShowCacheDatasourceImpl: TvShowCacheDatasource {
    private val tvShowList: ArrayList<TvShow> = ArrayList<TvShow>()
    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList.addAll(tvShows)
    }

    override suspend fun getTvShowsFromCache(): List<TvShow> = tvShowList.toList()
}