package com.tilaka.apps.architecture.components.ui.genre

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tilaka.apps.architecture.components.common.AppConstants
import com.tilaka.apps.architecture.components.common.Logger
import com.tilaka.apps.architecture.components.data.model.Characters
import com.tilaka.apps.architecture.components.databinding.ItemListCharacterBinding
import javax.inject.Inject

class CharacterAdapter(private var listAnimes: List<Characters>) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    @Inject
    lateinit var logger: Logger

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding =
            ItemListCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }


    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val itemCharacter = listAnimes[position]
        holder.binding.titleCharacter.text = itemCharacter.name
        Glide.with(holder.binding.imageCharacter.context)
            .load(itemCharacter.imageUrl)
            .into(holder.binding.imageCharacter)
        holder.binding.imageCharacter.setOnClickListener { itemView ->
            val actionDetailView =
                GenreFragmentDirections.actionGenreFragmentToListingFragment(itemCharacter.name)
            itemView.findNavController().navigate(actionDetailView)

        }

    }

    override fun getItemCount(): Int {
        return listAnimes.size
    }

    fun addAnimeItems(animesItems: List<Characters>) {
        logger.printMessage(AppConstants.LOG_TAG, "in addAnimeItems")
        this.listAnimes = animesItems
    }

    fun addListItems(listItems: List<Characters>) {
        this.listAnimes = listItems
    }

    inner class CharacterViewHolder(var binding: ItemListCharacterBinding) :
        RecyclerView.ViewHolder(binding.root)


}