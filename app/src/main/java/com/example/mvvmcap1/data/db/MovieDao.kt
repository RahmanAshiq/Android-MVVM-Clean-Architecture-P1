package com.example.mvvmcap1.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvmcap1.data.model.movie.Movie

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovies(movies: List<Movie>)

    @Query("DELETE from popular_movies")
    suspend fun deleteAllMovies()

    @Query("SELECT * from popular_movies")
    suspend fun getMovies(): List<Movie>
}