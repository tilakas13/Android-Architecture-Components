package com.tilaka.apps.architecture.components.ui.detail

import androidx.lifecycle.ViewModel
import com.tilaka.apps.architecture.components.data.model.CartoonItemModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class DeatailViewModel @Inject constructor() : ViewModel() {

    private lateinit var cartoonItem: CartoonItemModel

    fun setDetailModel(cartoonItem: CartoonItemModel) {
        this.cartoonItem = cartoonItem;
    }
}