package com.example.mvvmcap1.data.repository.movie

import android.util.Log
import com.example.mvvmcap1.data.model.movie.Movie
import com.example.mvvmcap1.data.model.movie.MovieList
import com.example.mvvmcap1.data.repository.movie.datasource.MovieCacheDatasource
import com.example.mvvmcap1.data.repository.movie.datasource.MovieLocalDatasource
import com.example.mvvmcap1.data.repository.movie.datasource.MovieRemoteDatasource
import com.example.mvvmcap1.domain.repsitory.MovieRepository
import retrofit2.Response

class MovieRepositoryImpl(
    private val movieRemoteDatasource: MovieRemoteDatasource,
    private val movieLocalDatasource: MovieLocalDatasource,
    private val movieCacheDatasource: MovieCacheDatasource
): MovieRepository {
    override suspend fun getMovies(): List<Movie>? = getMoviesFromCache()

    override suspend fun updateMovies(): List<Movie>? {
        val newMovieList = getMoviesFromAPI()
        movieLocalDatasource.deleteAllMoviesFromLocalDB()
        movieLocalDatasource.saveMoviesToLocalDB(newMovieList)
        movieCacheDatasource.saveMoviesToCache(newMovieList)

        return newMovieList
    }

    private suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            val response: Response<MovieList> = movieRemoteDatasource.getMoviesFromRemoteApi()
            val body: MovieList? = response.body()
            if(body != null) {
                movieList = body.movies
            }
        } catch (exception: Exception) {
            Log.e(this.javaClass.simpleName, exception.message.toString())
        }
        return movieList
    }

    private suspend fun getMoviesFromLocalDB(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieLocalDatasource.getMoviesFromLocalDB()
        } catch (exception: Exception) {
            Log.e(this.javaClass.simpleName, exception.message.toString())
        }
        if(movieList.isEmpty()) {
            movieList = getMoviesFromAPI()
            movieLocalDatasource.saveMoviesToLocalDB(movieList)
        }
        return movieList
    }

    private suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieCacheDatasource.getMoviesFromCache()
        } catch (exception: Exception) {
            Log.e(this.javaClass.simpleName, exception.message.toString())
        }
        if(movieList.isEmpty()) {
            movieList = getMoviesFromLocalDB()
            movieCacheDatasource.saveMoviesToCache(movieList)
        }
        return movieList
    }
}