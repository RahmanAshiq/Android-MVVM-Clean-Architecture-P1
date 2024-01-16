package com.example.mvvmcap1.data.repository.artist.datasource

import com.example.mvvmcap1.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDatasource {
    suspend fun getArtistFromRemoteApi(): Response<ArtistList>
}