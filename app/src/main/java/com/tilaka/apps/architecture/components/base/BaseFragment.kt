package com.tilaka.apps.architecture.components.base

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

open class BaseFragment : Fragment() {

    fun showSupportBar(show: Boolean) {
        if (show) {
            (requireActivity() as AppCompatActivity).supportActionBar?.show()
        } else {
            (requireActivity() as AppCompatActivity).supportActionBar?.hide()
        }
    }


   protected fun setTitle(title: String?) {
        (requireActivity() as AppCompatActivity).supportActionBar?.title = title
    }
}