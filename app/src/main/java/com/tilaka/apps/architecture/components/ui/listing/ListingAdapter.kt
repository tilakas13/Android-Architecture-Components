package com.tilaka.apps.architecture.components.ui.listing

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tilaka.apps.architecture.components.common.AppConstants
import com.tilaka.apps.architecture.components.common.Logger
import com.tilaka.apps.architecture.components.data.model.SearchResultItem
import com.tilaka.apps.architecture.components.databinding.ItemListAnimationBinding
import com.tilaka.apps.architecture.components.ui.listing.ListingAdapter.AnimesViewHolder

class ListingAdapter (private var listAnimes: List<SearchResultItem>) :
    RecyclerView.Adapter<AnimesViewHolder>() {

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimesViewHolder {
        val binding =
            ItemListAnimationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnimesViewHolder(binding)
    }


    override fun onBindViewHolder(holder: AnimesViewHolder, position: Int) {
        val itemAnimes = listAnimes[position]
        Logger.printMessage(AppConstants.LOG_TAG, "in onBindViewHolder $itemAnimes.name")
        holder.binding.title.text = itemAnimes.title
        Glide.with(holder.binding.imageAnime.context)
            .load(  itemAnimes.imageUrl)
            .centerCrop()
            .into(holder.binding.imageAnime)
        holder.binding.containerItemAnime.setOnClickListener { itemView ->
//            val actionDetailView =
//                AnimeListFragmentDirections.actionItemClickToDetailAnimeFragment(itemAnimes);
//            itemView.findNavController().navigate(actionDetailView)
        }

    }

    override fun getItemCount(): Int {
        return listAnimes.size
    }

    fun addAnimeItems(animesItems: List<SearchResultItem>) {
        Logger.printMessage(AppConstants.LOG_TAG, "in addAnimeItems")
        this.listAnimes = animesItems
    }

    inner class AnimesViewHolder(var binding: ItemListAnimationBinding) :
        RecyclerView.ViewHolder(binding.root)


}