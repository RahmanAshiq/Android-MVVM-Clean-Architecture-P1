package com.example.mvvmcap1.data.repository.tvshow.datasource

import com.example.mvvmcap1.data.model.tvshow.TvShow

interface TvShowLocalDatasource {
    suspend fun saveTvShowsToLocalDB(tvShows: List<TvShow>)
    suspend fun deleteAllTvShowsFromLocalDB()
    suspend fun getAllTvShowsFromLocalDB(): List<TvShow>
}