package com.tilaka.apps.architecture.components.ui.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.tilaka.apps.architecture.components.R
import com.tilaka.apps.architecture.components.databinding.DetailFragmentBinding

class DetailFragment : Fragment() {


    private lateinit var binding: DetailFragmentBinding
    private lateinit var viewModel: DeatailViewModel
    private val navigationArgs: DetailFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        //return inflater.inflate(R.layout.detail_fragment, container, false)
        binding = DetailFragmentBinding.inflate(inflater, container, false)
        return binding.root;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val cartoonItem = navigationArgs.itemDetail;
        viewModel = ViewModelProvider(this).get(DeatailViewModel::class.java)

        binding.title.text = cartoonItem.title


        activity?.let {
            Glide.with(it)
                .load(cartoonItem.imageUrl)
                .centerCrop()
                .into(binding.imageCartoon)
        }

        binding.detail.text = cartoonItem.synopsis
    }

}