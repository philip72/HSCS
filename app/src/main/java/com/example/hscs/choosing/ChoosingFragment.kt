package com.example.hscs.choosing

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hscs.Auth.AuthActions
import com.example.hscs.Auth.AuthUIState
import com.example.hscs.Auth.AuthViewModel
import androidx.navigation.fragment.findNavController
import com.example.hscs.util.observeEvent
import com.example.hscs.util.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.example.hscs.R
import com.example.hscs.databinding.FragmentChoosingBinding

class ChoosingFragment : Fragment(R.layout.fragment_choosing) {
    private val binding by viewBinding(FragmentChoosingBinding::bind)
    private val viewModel: ChoosingViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        passData()
        setUpObservers()
        onClick()

    }

    private fun onClick() {
        binding.apply {

            PatientButton.setOnClickListener{
                viewModel.navigateToPatientSignIn()

            }
            SpecilaistButton.setOnClickListener{
                viewModel.navigateToSpecialist()
            }

        }

}



    private fun passData() {

    }

    private fun setUpObservers() {
        viewModel.uiState.observe(viewLifecycleOwner) {
            when (it) {
                ChoosingUIState.Loading ->{}  //renderLoading()
                is ChoosingUIState.Error -> {
                    //renderError(errorTitle = it.title, errorMessage = it.message)
                }
                else -> {}
            }
        }

        viewModel.interactions.observeEvent(viewLifecycleOwner) {
            when (it) {
                is ChoosingActions.Navigate -> findNavController().navigate(it.destination)
            }
        }
    }



}