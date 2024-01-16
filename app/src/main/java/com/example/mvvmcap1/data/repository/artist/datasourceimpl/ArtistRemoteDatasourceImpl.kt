package com.example.mvvmcap1.data.repository.artist.datasourceimpl

import com.example.mvvmcap1.data.api.TMDBService
import com.example.mvvmcap1.data.model.artist.ArtistList
import com.example.mvvmcap1.data.repository.artist.datasource.ArtistRemoteDatasource
import retrofit2.Response

class ArtistRemoteDatasourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey: String,
): ArtistRemoteDatasource  {
    override suspend fun getArtistFromRemoteApi(): Response<ArtistList> = tmdbService.getPopularArtists(apiKey = apiKey)
}