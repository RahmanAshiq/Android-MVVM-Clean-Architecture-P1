package com.example.mvvmcap1.data.repository.movie.datasourceimpl

import com.example.mvvmcap1.data.api.TMDBService
import com.example.mvvmcap1.data.model.movie.MovieList
import com.example.mvvmcap1.data.repository.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

class MovieRemoteDatasourceImpl(private val tmdbService: TMDBService, private val apiKey: String): MovieRemoteDatasource {
    override suspend fun getMoviesFromRemoteApi(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)
}