package com.example.mvvmcap1.data.repository.artist.datasourceimpl

import com.example.mvvmcap1.data.model.artist.Artist
import com.example.mvvmcap1.data.repository.artist.datasource.ArtistCacheDatasource

class ArtistCacheDatasourceImpl: ArtistCacheDatasource {
    private val artistList: ArrayList<Artist> = ArrayList<Artist>()
    override suspend fun saveArtistsToCache(artists: List<Artist>) {
        artistList.clear()
        artistList.addAll(artists)
    }

    override suspend fun getArtistsFromCache(): List<Artist> = artistList.toList()
}