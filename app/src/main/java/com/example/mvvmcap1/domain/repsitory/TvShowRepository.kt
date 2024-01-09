package com.example.mvvmcap1.domain.repsitory

import com.example.mvvmcap1.data.model.tvshow.TvShow

interface TvShowRepository {
    suspend fun getTvShows(): List<TvShow>?
    suspend fun updateTvShows(): List<TvShow>?
}