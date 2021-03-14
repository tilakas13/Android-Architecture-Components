package com.tilaka.apps.architecture.components.ui.genre

import CharacterResponseModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.tilaka.apps.architecture.components.data.network.ApiService
import com.tilaka.apps.architecture.components.data.network.Resource
import kotlinx.coroutines.Dispatchers

class GenreViewModel : ViewModel() {
    private var data: CharacterResponseModel? = null
    private lateinit var apiService: ApiService

    fun setRepository(airlinesRepository: ApiService) {
        this.apiService = airlinesRepository
    }

    fun getListCharacters() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data))
        try {
            data = apiService.getCharacters()
            emit(Resource.success(data))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error occured"))
        }
    }
}