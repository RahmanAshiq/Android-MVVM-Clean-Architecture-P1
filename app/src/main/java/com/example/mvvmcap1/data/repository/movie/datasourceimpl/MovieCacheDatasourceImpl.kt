package com.example.mvvmcap1.data.repository.movie.datasourceimpl

import com.example.mvvmcap1.data.model.movie.Movie
import com.example.mvvmcap1.data.repository.movie.datasource.MovieCacheDatasource

class MovieCacheDatasourceImpl: MovieCacheDatasource {

    private val movieList: ArrayList<Movie> = ArrayList<Movie>()
    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList.addAll(movies)
    }

    override suspend fun getMoviesFromCache(): List<Movie> = movieList.toList()
}