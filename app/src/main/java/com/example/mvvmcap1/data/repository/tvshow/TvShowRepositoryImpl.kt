package com.example.mvvmcap1.data.repository.tvshow

import android.util.Log
import com.example.mvvmcap1.data.model.tvshow.TvShow
import com.example.mvvmcap1.data.model.tvshow.TvShowList
import com.example.mvvmcap1.data.repository.tvshow.datasource.TvShowCacheDatasource
import com.example.mvvmcap1.data.repository.tvshow.datasource.TvShowLocalDatasource
import com.example.mvvmcap1.data.repository.tvshow.datasource.TvShowRemoteDatasource
import com.example.mvvmcap1.domain.repsitory.TvShowRepository
import retrofit2.Response

class TvShowRepositoryImpl(
    private val tvShowRemoteDatasource: TvShowRemoteDatasource,
    private val tvShowLocalDatasource: TvShowLocalDatasource,
    private val tvShowCacheDatasource: TvShowCacheDatasource
): TvShowRepository {
    override suspend fun getTvShows(): List<TvShow> = getTvShowsFromCache()

    override suspend fun updateTvShows(): List<TvShow>? {
        val newTvShowList = getTvShowsFromRemoteApi()
        tvShowLocalDatasource.deleteAllTvShowsFromLocalDB()
        tvShowLocalDatasource.saveTvShowsToLocalDB(newTvShowList)
        tvShowCacheDatasource.saveTvShowsToCache(newTvShowList)
         
        return newTvShowList
    }

    private suspend fun getTvShowsFromRemoteApi(): List<TvShow> {
        lateinit var tvShows: List<TvShow>
        try {
            val response: Response<TvShowList> = tvShowRemoteDatasource.getTvShowsFromRemoteApi()
            val body = response.body()
            if(body != null) {
                tvShows = body.tvShows
            }
        } catch (exception: Exception) {
            Log.e(this.javaClass.simpleName, exception.message.toString())
        }
        return  tvShows
    }

    private suspend fun getTvShowsFromLocalDB(): List<TvShow> {
        lateinit var tvShows: List<TvShow>
        try {
            tvShows = tvShowLocalDatasource.getAllTvShowsFromLocalDB()
        } catch (exception: Exception) {
            Log.e(this.javaClass.simpleName, exception.message.toString())
        }
        if(tvShows.isEmpty()) {
            tvShows = getTvShowsFromRemoteApi()
            tvShowLocalDatasource.saveTvShowsToLocalDB(tvShows)
        }
        return tvShows
    }

    private suspend fun getTvShowsFromCache(): List<TvShow> {
        lateinit var tvShows: List<TvShow>
        try {
            tvShows = tvShowCacheDatasource.getTvShowsFromCache()
        } catch (exception: Exception) {
            Log.e(this.javaClass.simpleName, exception.message.toString())
        }
        if(tvShows.isEmpty()) {
            tvShows = getTvShowsFromLocalDB()
            tvShowCacheDatasource.saveTvShowsToCache(tvShows)
        }
        return tvShows
    }
}