package com.tilaka.apps.architecture.components.ui.genre

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.tilaka.apps.architecture.components.data.network.ApiService
import com.tilaka.apps.architecture.components.data.network.Resource
import kotlinx.coroutines.Dispatchers

class GenreViewModel : ViewModel() {
    private lateinit var apiService: ApiService

    fun setRepository(airlinesRepository: ApiService) {
        this.apiService = airlinesRepository
    }

    fun getListCharacters() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = apiService.getCharacters( )))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error occured"))
        }
    }
}