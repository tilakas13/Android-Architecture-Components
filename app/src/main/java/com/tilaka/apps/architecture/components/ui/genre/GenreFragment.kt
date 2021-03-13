package com.tilaka.apps.architecture.components.ui.genre

import Characters
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.tilaka.apps.architecture.components.common.AppConstants
import com.tilaka.apps.architecture.components.common.Logger
import com.tilaka.apps.architecture.components.data.model.SearchResultItem
import com.tilaka.apps.architecture.components.data.network.RetrofitClient
import com.tilaka.apps.architecture.components.data.network.Status
import com.tilaka.apps.architecture.components.databinding.FragmentGenreBinding
import com.tilaka.apps.architecture.components.ui.listing.ListingAdapter

class GenreFragment : Fragment() {

    companion object {
        fun newInstance() = GenreFragment()
    }

    private lateinit var adapterCharacters: CharacterAdapter
    private lateinit var binding: FragmentGenreBinding
    private lateinit var viewModel: GenreViewModel
    private val animesList = ArrayList<Characters>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentGenreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GenreViewModel::class.java)
        viewModel.setRepository(RetrofitClient.apiService)


        adapterCharacters = CharacterAdapter(animesList)
        binding.recyclerviewCharacters.layoutManager = GridLayoutManager(activity, 2)
        binding.recyclerviewCharacters.adapter = adapterCharacters

        viewModel.getListCharacters().observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        Logger.printMessage(AppConstants.LOG_TAG, "data loaded")
                        binding.progressBar.visibility = View.GONE
                        resource.data?.let { listAnims ->

                                this.updateListItems(listAnims.characters)

                        }
                    }
                    Status.ERROR -> {
                        Logger.printMessage(AppConstants.LOG_TAG, "Status.ERROR ")
                        binding.progressBar.visibility = View.GONE
                    }
                    Status.LOADING -> {
                        Logger.printMessage(AppConstants.LOG_TAG, "Status.LOADING")
                        binding.progressBar.visibility = View.VISIBLE
                    }
                }
            }
        })


    }

    private fun updateListItems(listItems: List<Characters>) {
        adapterCharacters.apply {
            addListItems(listItems)
            notifyDataSetChanged()
        }
    }
}