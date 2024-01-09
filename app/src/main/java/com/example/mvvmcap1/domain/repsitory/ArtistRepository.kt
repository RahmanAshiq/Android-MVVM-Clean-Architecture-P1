package com.example.mvvmcap1.domain.repsitory

import com.example.mvvmcap1.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtists(): List<Artist>?
    suspend fun updateArtists(): List<Artist>?
}