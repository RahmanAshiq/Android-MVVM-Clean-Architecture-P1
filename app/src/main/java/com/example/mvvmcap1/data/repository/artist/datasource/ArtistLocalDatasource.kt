package com.example.mvvmcap1.data.repository.artist.datasource

import com.example.mvvmcap1.data.model.artist.Artist

interface ArtistLocalDatasource {
    suspend fun saveArtistsToLocalDB(artists: List<Artist>)
    suspend fun deleteAllArtistsFromLocalDB()
    suspend fun getAllArtistsFromLocalDB(): List<Artist>
}