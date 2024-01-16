package com.example.mvvmcap1.data.repository.artist

import android.util.Log
import com.example.mvvmcap1.data.model.artist.Artist
import com.example.mvvmcap1.data.model.artist.ArtistList
import com.example.mvvmcap1.data.repository.artist.datasource.ArtistCacheDatasource
import com.example.mvvmcap1.data.repository.artist.datasource.ArtistLocalDatasource
import com.example.mvvmcap1.data.repository.artist.datasource.ArtistRemoteDatasource
import com.example.mvvmcap1.domain.repsitory.ArtistRepository
import retrofit2.Response

class ArtistRepositoryImpl(
    private val artistRemoteDatasource: ArtistRemoteDatasource,
    private val artistLocalDatasource: ArtistLocalDatasource,
    private val artistCacheDatasource: ArtistCacheDatasource,
): ArtistRepository {
    override suspend fun getArtists(): List<Artist>? = getArtistsFromCache()

    override suspend fun updateArtists(): List<Artist>? {
        val artistList: List<Artist> = getArtistsFromRemoteApi()
        artistLocalDatasource.deleteAllArtistsFromLocalDB()
        artistLocalDatasource.saveArtistsToLocalDB(artistList)
        artistCacheDatasource.saveArtistsToCache(artistList)
        return artistList
    }

    private suspend fun getArtistsFromRemoteApi(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            val response: Response<ArtistList> = artistRemoteDatasource.getArtistFromRemoteApi()
            val body = response.body()
            if(body != null) {
                artistList = body.artists
            }
        } catch (exception: Exception) {
            Log.e(this.javaClass.simpleName, exception.message.toString())
        }
        return artistList
    }

    private suspend fun getArtistsFromLocalDB(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDatasource.getAllArtistsFromLocalDB()
        } catch (exception: Exception) {
            Log.e(this.javaClass.simpleName, exception.message.toString())
        }
        if(artistList.isEmpty()) {
            artistList = getArtistsFromRemoteApi()
            artistLocalDatasource.saveArtistsToLocalDB(artistList)
        }
        return artistList
    }

    private suspend fun getArtistsFromCache(): List<Artist> {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistCacheDatasource.getArtistsFromCache()
        } catch (exception: Exception) {
            Log.e(this.javaClass.simpleName, exception.message.toString())
        }
        if(artistList.isEmpty()) {
            artistList = getArtistsFromLocalDB()
            artistCacheDatasource.saveArtistsToCache(artistList)
        }
        return artistList
    }
}