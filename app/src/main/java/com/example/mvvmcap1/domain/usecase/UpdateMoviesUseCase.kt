package com.example.mvvmcap1.domain.usecase

import com.example.mvvmcap1.data.model.movie.Movie
import com.example.mvvmcap1.domain.repsitory.MovieRepository

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {
    suspend fun execute(): List<Movie>? = movieRepository.updateMovies()
}