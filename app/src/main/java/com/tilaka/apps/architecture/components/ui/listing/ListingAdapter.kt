package com.tilaka.apps.architecture.components.ui.listing

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tilaka.apps.architecture.components.common.AppConstants
import com.tilaka.apps.architecture.components.common.Logger
import com.tilaka.apps.architecture.components.data.model.CartoonItemModel
import com.tilaka.apps.architecture.components.databinding.ItemListAnimationBinding
import com.tilaka.apps.architecture.components.ui.listing.ListingAdapter.AnimesViewHolder
import javax.inject.Inject

class ListingAdapter(private var listAnimes: List<CartoonItemModel>) :
    RecyclerView.Adapter<AnimesViewHolder>() {

    @Inject
    lateinit var logger: Logger

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimesViewHolder {
        val binding =
            ItemListAnimationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimesViewHolder(binding)
    }


    override fun onBindViewHolder(holder: AnimesViewHolder, position: Int) {
        val itemCartoon = listAnimes[position]
        holder.binding.title.text = itemCartoon.title
        Glide.with(holder.binding.imageAnime.context)
            .load(itemCartoon.imageUrl)
            .circleCrop()
            .into(holder.binding.imageAnime)
        holder.binding.containerItemAnime.setOnClickListener { itemView ->
            val actionDetailView =
                ListingFragmentDirections.actionListingFragmentToDetailFragment(itemCartoon);
            itemView.findNavController().navigate(actionDetailView)

        }

    }

    override fun getItemCount(): Int {
        return listAnimes.size
    }

    fun addAnimeItems(animesItems: List<CartoonItemModel>) {
        logger.printMessage(AppConstants.LOG_TAG, "in addAnimeItems")
        this.listAnimes = animesItems
    }

    fun addListItems(listItems: List<CartoonItemModel>) {
        this.listAnimes = listItems
    }

    inner class AnimesViewHolder(var binding: ItemListAnimationBinding) :
        RecyclerView.ViewHolder(binding.root)


}