package com.example.mvvmcap1.presentation.artist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mvvmcap1.data.model.artist.Artist
import com.example.mvvmcap1.domain.usecase.GetArtistsUseCase
import com.example.mvvmcap1.domain.usecase.UpdateArtistsUseCase

class ArtistViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase,
): ViewModel() {

    fun getArtists(): LiveData<List<Artist>?> = liveData {
        val artistList: List<Artist>? = getArtistsUseCase.execute()
        emit(artistList)
    }

    fun updateArtists(): LiveData<List<Artist>?> = liveData {
        val artistList: List<Artist>? = updateArtistsUseCase.execute()
        emit(artistList)
    }
}