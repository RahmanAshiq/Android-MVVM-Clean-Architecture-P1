package com.example.mvvmcap1.data.repository.movie.datasourceimpl

import com.example.mvvmcap1.data.db.MovieDao
import com.example.mvvmcap1.data.model.movie.Movie
import com.example.mvvmcap1.data.repository.movie.datasource.MovieLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDatasourceImpl(private val movieDao: MovieDao): MovieLocalDatasource {
    override suspend fun saveMoviesToLocalDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun deleteAllMoviesFromLocalDB() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }

    override suspend fun getMoviesFromLocalDB(): List<Movie> = movieDao.getMovies()
}