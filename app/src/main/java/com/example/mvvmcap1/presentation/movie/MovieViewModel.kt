package com.example.mvvmcap1.presentation.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mvvmcap1.data.model.movie.Movie
import com.example.mvvmcap1.domain.usecase.GetMoviesUseCase
import com.example.mvvmcap1.domain.usecase.UpdateMoviesUseCase

class MovieViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase,
): ViewModel() {

    fun getMovies(): LiveData<List<Movie>?> = liveData {
        val movieList: List<Movie>? = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies(): LiveData<List<Movie>?> = liveData {
        val movieList: List<Movie>? = updateMoviesUseCase.execute()
        emit(movieList)
    }
}