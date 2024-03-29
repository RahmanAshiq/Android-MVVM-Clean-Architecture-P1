package com.example.mvvmcap1.presentation.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mvvmcap1.data.model.tvshow.TvShow
import com.example.mvvmcap1.domain.usecase.GetTvShowsUseCase
import com.example.mvvmcap1.domain.usecase.UpdateTvShowsUseCase

class TvShowViewModel(
    private val getTvShowsUseCase: GetTvShowsUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase,
): ViewModel() {

    fun getTvShows(): LiveData<List<TvShow>?> = liveData {
        val tvShowList: List<TvShow>? = getTvShowsUseCase.execute()
        emit(tvShowList)
    }

    fun updateTvShows(): LiveData<List<TvShow>?> = liveData {
        val tvShowList: List<TvShow>? = updateTvShowsUseCase.execute()
        emit(tvShowList)
    }
}