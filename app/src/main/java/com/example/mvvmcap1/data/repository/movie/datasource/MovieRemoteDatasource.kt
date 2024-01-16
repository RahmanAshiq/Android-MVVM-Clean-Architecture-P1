package com.example.mvvmcap1.data.repository.movie.datasource

import com.example.mvvmcap1.data.model.movie.MovieList
import retrofit2.Response


interface MovieRemoteDatasource {
    suspend fun getMoviesFromRemoteApi(): Response<MovieList>
}