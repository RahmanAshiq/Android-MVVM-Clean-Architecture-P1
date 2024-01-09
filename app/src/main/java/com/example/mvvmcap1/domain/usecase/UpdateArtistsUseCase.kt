package com.example.mvvmcap1.domain.usecase

import com.example.mvvmcap1.data.model.artist.Artist
import com.example.mvvmcap1.domain.repsitory.ArtistRepository

class UpdateArtistsUseCase(private val artistRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>? = artistRepository.updateArtists()
}