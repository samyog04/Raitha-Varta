package com.raithavarta.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.raithavarta.RaithaVartaApp
import com.raithavarta.databinding.FragmentHomeBinding
import com.raithavarta.ui.adapter.TipPagerAdapter
import com.raithavarta.ui.viewmodel.TipViewModel
import com.raithavarta.ui.viewmodel.TipViewModelFactory

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: TipViewModel by activityViewModels {
        TipViewModelFactory((requireActivity().application as RaithaVartaApp).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = TipPagerAdapter()
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        viewModel.allTips.observe(viewLifecycleOwner) { tips ->
            adapter.submitList(tips)
        }

        viewModel.allCategories.observe(viewLifecycleOwner) { categories ->
            binding.chipGroup.removeAllViews()
            val allChip = com.google.android.material.chip.Chip(requireContext())
            allChip.text = "All"
            allChip.isCheckable = true
            allChip.isChecked = true
            allChip.setOnClickListener { viewModel.filterTips(null) }
            binding.chipGroup.addView(allChip)

            categories.forEach { category ->
                val chip = com.google.android.material.chip.Chip(requireContext())
                chip.text = category.name
                chip.isCheckable = true
                chip.setOnClickListener { viewModel.filterTips(category.id) }
                binding.chipGroup.addView(chip)
            }
        }

        viewModel.filteredTips.observe(viewLifecycleOwner) { tips ->
            adapter.submitList(tips)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}