package com.tilaka.apps.architecture.components.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.tilaka.apps.architecture.components.base.BaseFragment
import com.tilaka.apps.architecture.components.databinding.DetailFragmentBinding

class DetailFragment : BaseFragment() {

    private lateinit var binding: DetailFragmentBinding
    private lateinit var viewModel: DeatailViewModel
    private val navigationArgs: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        showSupportBar(true)
        binding = DetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val cartoonItem = navigationArgs.itemDetail
        setTitle(cartoonItem.title)
        viewModel = ViewModelProvider(this).get(DeatailViewModel::class.java)
        binding.title.text = cartoonItem.title
        Glide.with(binding.imageCartoon.context)
            .load(cartoonItem.imageUrl)
            .centerCrop()
            .into(binding.imageCartoon)
        binding.detail.text = cartoonItem.synopsis
        binding.rating.text = cartoonItem.rated
        binding.externalUrl.text = cartoonItem.url
    }

}