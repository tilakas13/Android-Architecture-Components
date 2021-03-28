package com.tilaka.apps.architecture.components.base

import android.text.TextUtils
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.tilaka.apps.architecture.components.R

open class BaseFragment : Fragment() {

    fun showSupportBar(show: Boolean) {
        setHasOptionsMenu(show)
        val toolBar = (requireActivity() as AppCompatActivity).supportActionBar
        if (show) toolBar?.show() else toolBar?.hide()
        toolBar?.let {
            it.setHomeButtonEnabled(show)
            it.setDisplayShowHomeEnabled(show)
            it.setDisplayHomeAsUpEnabled(show)
        }
    }


    protected fun setTitle(title: String?) {
        (requireActivity() as AppCompatActivity).supportActionBar?.title =
            if (TextUtils.isEmpty(title)) getString(R.string.app_name) else title
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                activity?.onBackPressed()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}