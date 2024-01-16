package com.example.mvvmcap1.data.repository.tvshow.datasourceimpl

import com.example.mvvmcap1.data.db.TvShowDao
import com.example.mvvmcap1.data.model.tvshow.TvShow
import com.example.mvvmcap1.data.repository.tvshow.datasource.TvShowLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDatasourceImpl(private val tvShowDao: TvShowDao): TvShowLocalDatasource{
    override suspend fun saveTvShowsToLocalDB(tvShows: List<TvShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShows(tvShows)
        }
    }

    override suspend fun deleteAllTvShowsFromLocalDB() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShows()
        }
    }

    override suspend fun getAllTvShowsFromLocalDB() = tvShowDao.getTvShows()
}