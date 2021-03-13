package com.tilaka.apps.architecture.components.ui.listing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.tilaka.apps.architecture.components.data.network.ApiService
import com.tilaka.apps.architecture.components.data.network.Resource
import kotlinx.coroutines.Dispatchers

class ListingViewModel() : ViewModel() {

    private lateinit var apiService: ApiService

    fun setRepository(airlinesRepository: ApiService) {
        this.apiService = airlinesRepository
    }
    fun getListAnims(animType: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = apiService.getListAnimes(animType)))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error occured"))
        }
    }
}