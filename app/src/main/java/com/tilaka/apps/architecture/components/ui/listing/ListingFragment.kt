package com.tilaka.apps.architecture.components.ui.listing

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.tilaka.apps.architecture.components.R
import com.tilaka.apps.architecture.components.data.model.SearchResultItem
import com.tilaka.apps.architecture.components.databinding.ListingFragmentBinding

class ListingFragment : Fragment() {

    companion object {
        fun newInstance() = ListingFragment()
    }

    private lateinit var adapterAnimes: ListingAdapter
    private lateinit var binding: ListingFragmentBinding
    private lateinit var viewModel: ListingViewModel
    private val animesList = ArrayList<SearchResultItem>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
      binding =   ListingFragmentBinding.inflate(inflater,container,false)
       return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListingViewModel::class.java)
        val layoutManager = LinearLayoutManager(activity)
        adapterAnimes = ListingAdapter(animesList)
        binding.recyclerviewAnimes.layoutManager = layoutManager
        binding.recyclerviewAnimes.adapter = adapterAnimes
    }

}