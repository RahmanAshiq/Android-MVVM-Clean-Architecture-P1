package com.example.mvvmcap1.data.repository.artist.datasourceimpl

import com.example.mvvmcap1.data.db.ArtistDao
import com.example.mvvmcap1.data.model.artist.Artist
import com.example.mvvmcap1.data.repository.artist.datasource.ArtistLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDatasourceImpl(private val artistDao: ArtistDao): ArtistLocalDatasource {
    override suspend fun saveArtistsToLocalDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtists(artists)
        }
    }

    override suspend fun deleteAllArtistsFromLocalDB() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtists()
        }
    }

    override suspend fun getAllArtistsFromLocalDB(): List<Artist> = artistDao.getArtists()
}