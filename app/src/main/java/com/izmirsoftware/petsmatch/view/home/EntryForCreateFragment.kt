package com.izmirsoftware.petsmatch.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.izmirsoftware.petsmatch.databinding.FragmentEntryForCreateBinding
import com.izmirsoftware.petsmatch.model.Pet
import com.izmirsoftware.petsmatch.util.hideBottomNavigation
import com.izmirsoftware.petsmatch.util.showBottomNavigation
import com.izmirsoftware.petsmatch.viewmodel.home.EntryForCreateViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EntryForCreateFragment : Fragment() {
    private val viewModel: EntryForCreateViewModel by viewModels()
    private var _binding: FragmentEntryForCreateBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEntryForCreateBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setOnClickItems()

        return root
    }

    private fun setOnClickItems() {
        with(binding) {
            fab.setOnClickListener {
                gotoCreatePetPage1(it)
            }
        }
    }

    private fun gotoCreatePetPage1(view: View) {
        val direction =
            EntryForCreateFragmentDirections.actionEntryForCreateFragmentToCreatePetPage1Fragment(
                Pet()
            )
        Navigation.findNavController(view).navigate(direction)
    }

    override fun onStart() {
        super.onStart()
        hideBottomNavigation(requireActivity())
    }

    override fun onStop() {
        super.onStop()
        showBottomNavigation(requireActivity())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}