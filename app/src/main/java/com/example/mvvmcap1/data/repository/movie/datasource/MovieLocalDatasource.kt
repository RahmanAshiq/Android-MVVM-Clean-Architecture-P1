package com.example.mvvmcap1.data.repository.movie.datasource

import com.example.mvvmcap1.data.model.movie.Movie

interface MovieLocalDatasource {
    suspend fun saveMoviesToLocalDB(movies: List<Movie>)
    suspend fun deleteAllMoviesFromLocalDB()
    suspend fun getMoviesFromLocalDB(): List<Movie>
}