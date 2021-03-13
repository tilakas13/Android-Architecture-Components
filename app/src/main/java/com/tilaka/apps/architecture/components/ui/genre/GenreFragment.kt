package com.tilaka.apps.architecture.components.ui.genre

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.tilaka.apps.architecture.components.R
import com.tilaka.apps.architecture.components.databinding.FragmentGenreBinding

class GenreFragment : Fragment() {

    companion object {
        fun newInstance() = GenreFragment()
    }

    private lateinit var binding: FragmentGenreBinding
    private lateinit var viewModel: GenreViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGenreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GenreViewModel::class.java)

//        binding.textGenre.setOnClickListener {
//            findNavController().navigate(R.id.action_genreFragment_to_listingFragment)
//        }
    }


}