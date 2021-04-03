package com.tilaka.apps.architecture.components.ui.listing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.tilaka.apps.architecture.components.data.model.CartoonSearchResultModel
import com.tilaka.apps.architecture.components.data.network.ApiService
import com.tilaka.apps.architecture.components.data.network.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject


@HiltViewModel
class ListingViewModel @Inject constructor() : ViewModel() {

    private lateinit var data: CartoonSearchResultModel
    private lateinit var apiService: ApiService

    fun setRepository(airlinesRepository: ApiService) {
        this.apiService = airlinesRepository
    }

    fun getListAnims(animType: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            data = apiService.getListAnimes(animType)
            emit(Resource.success(data))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error occured"))
        }
    }
}