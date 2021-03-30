package com.tilaka.apps.architecture.components.ui.listing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.tilaka.apps.architecture.components.base.BaseFragment
import com.tilaka.apps.architecture.components.common.AppConstants
import com.tilaka.apps.architecture.components.common.Logger
import com.tilaka.apps.architecture.components.data.model.CartoonItemModel
import com.tilaka.apps.architecture.components.data.network.RetrofitClient
import com.tilaka.apps.architecture.components.data.network.Status
import com.tilaka.apps.architecture.components.databinding.ListingFragmentBinding
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ListingFragment : BaseFragment() {

    private lateinit var adapterAnimes: ListingAdapter
    private lateinit var binding: ListingFragmentBinding
    private val viewModel: ListingViewModel by viewModels()
    private val animationList = ArrayList<CartoonItemModel>()

    private val navigationArgs: ListingFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        showSupportBar(true)
        binding = ListingFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val character = navigationArgs.character
        setTitle(character)
        Logger.printMessage(AppConstants.LOG_TAG, "Character Selected --->$character")
        viewModel.setRepository(RetrofitClient.apiService)
        val layoutManager = LinearLayoutManager(activity)
        adapterAnimes = ListingAdapter(animationList)
        binding.recyclerviewAnimes.layoutManager = layoutManager
        binding.recyclerviewAnimes.adapter = adapterAnimes


        viewModel.getListAnims(character).observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        Logger.printMessage(AppConstants.LOG_TAG, "data loaded")
                        binding.progressBar.visibility = View.GONE
                        resource.data?.let { listAnims ->
                            listAnims.results?.let { it1 ->
                                this.updateListItems(it1)
                            }
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

    private fun updateListItems(listItems: List<CartoonItemModel>) {
        adapterAnimes.apply {
            addListItems(listItems)
            notifyDataSetChanged()
        }
    }

}