package com.example.mvvmcap1.data.repository.artist.datasource

import com.example.mvvmcap1.data.model.artist.Artist

interface ArtistCacheDatasource {
    suspend fun saveArtistsToCache(artists: List<Artist>)
    suspend fun getArtistsFromCache(): List<Artist>
}