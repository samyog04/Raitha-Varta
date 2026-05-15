package com.raithavarta.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.raithavarta.RaithaVartaApp
import com.raithavarta.databinding.FragmentSuccessStoriesBinding
import com.raithavarta.ui.adapter.SuccessStoryAdapter
import com.raithavarta.ui.viewmodel.TipViewModel
import com.raithavarta.ui.viewmodel.TipViewModelFactory

class SuccessStoriesFragment : Fragment() {

    private var _binding: FragmentSuccessStoriesBinding? = null
    private val binding get() = _binding!!

    private val viewModel: TipViewModel by activityViewModels {
        TipViewModelFactory((requireActivity().application as RaithaVartaApp).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSuccessStoriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = SuccessStoryAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter
        viewModel.allStories.observe(viewLifecycleOwner) { stories ->
            adapter.submitList(stories)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}