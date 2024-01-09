package com.example.mvvmcap1.domain.repsitory

import com.example.mvvmcap1.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>?

    suspend fun updateMovies(): List<Movie>?
}