package com.example.mvvmcap1.domain.usecase

import com.example.mvvmcap1.data.model.tvshow.TvShow
import com.example.mvvmcap1.domain.repsitory.TvShowRepository

class GetTvShowsUseCase(private val tvShowRepository: TvShowRepository) {
    suspend fun execute(): List<TvShow>? = tvShowRepository.getTvShows()
}