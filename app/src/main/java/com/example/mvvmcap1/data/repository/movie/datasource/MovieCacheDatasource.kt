package com.example.mvvmcap1.data.repository.movie.datasource

import com.example.mvvmcap1.data.model.movie.Movie

interface MovieCacheDatasource {
    suspend fun saveMoviesToCache(movies: List<Movie>)
    suspend fun getMoviesFromCache(): List<Movie>
}