package com.tilaka.apps.architecture.components.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.tilaka.apps.architecture.components.base.BaseFragment
import com.tilaka.apps.architecture.components.databinding.DetailFragmentBinding

class DetailFragment : BaseFragment() {

    private lateinit var binding: DetailFragmentBinding
    private val viewModel: DeatailViewModel by viewModels()
    private val navigationArgs: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        showSupportBar(true)
        binding = DetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cartoonItem = navigationArgs.itemDetail
        viewModel.setDetailModel(cartoonItem)
        setTitle(cartoonItem.title)
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