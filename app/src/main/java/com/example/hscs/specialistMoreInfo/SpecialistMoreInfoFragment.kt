package com.example.hscs.specialistMoreInfo

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hscs.R
import com.example.hscs.SpecialistAuth.SignUp.SpecialistSignUpActions
import com.example.hscs.SpecialistAuth.SignUp.SpecialistSignUpUIState
import com.example.hscs.SpecialistAuth.SignUp.SpecialistSignUpViewModel
import com.example.hscs.databinding.FragmentSpecialistMoreInfoBinding
import com.example.hscs.databinding.FragmentSpecialistSignUpBinding
import com.example.hscs.util.observeEvent
import com.example.hscs.util.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SpecialistMoreInfoFragment : Fragment(R.layout.fragment_specialist_more_info) {

    private val binding by viewBinding(FragmentSpecialistMoreInfoBinding::bind)
    private val viewModel: SpecialistMoreInfoViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        passData()
        setUpObservers()
        onClick()

    }

    private fun onClick() {
        binding.apply {

            SpecialistMoreDetails.setOnClickListener{
                viewModel.navigateToSpecialistTextPage()

            }

        }

    }
    private fun passData() {
    }
    private fun setUpObservers() {
        viewModel.uiState.observe(viewLifecycleOwner) {
            when (it) {
                SpecialistMoreDetailsUIState.Loading ->{}  //renderLoading()
                is SpecialistMoreDetailsUIState.Error -> {
                    //renderError(errorTitle = it.title, errorMessage = it.message)
                }
                else -> {}
            }
        }

        viewModel.interactions.observeEvent(viewLifecycleOwner) {
            when (it) {
                is SpecialistMoreDetailsActions.Navigate -> findNavController().navigate(it.destination)
            }
        }
    }

}