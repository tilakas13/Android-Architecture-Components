package com.tilaka.apps.architecture.components.ui.genre

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.tilaka.apps.architecture.components.data.model.CharacterResponseModel
import com.tilaka.apps.architecture.components.data.network.ApiService
import com.tilaka.apps.architecture.components.data.network.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class GenreViewModel @Inject  constructor() : ViewModel() {
    var data: CharacterResponseModel? = null
    lateinit var apiService: ApiService

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