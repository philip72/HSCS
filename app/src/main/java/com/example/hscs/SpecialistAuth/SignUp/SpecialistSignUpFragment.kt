package com.example.hscs.SpecialistAuth.SignUp

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hscs.PatientAuth.SignUp.PatientSignUpActions
import com.example.hscs.PatientAuth.SignUp.PatientSignUpUIState
import com.example.hscs.PatientAuth.SignUp.PatientSignUpViewModel
import com.example.hscs.R
import com.example.hscs.databinding.FragmentPatientSignUpBinding
import com.example.hscs.databinding.FragmentSpecialistSignUpBinding
import com.example.hscs.util.observeEvent
import com.example.hscs.util.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SpecialistSignUpFragment : Fragment(R.layout.fragment_specialist_sign_up) {

    private val binding by viewBinding(FragmentSpecialistSignUpBinding::bind)
    private val viewModel: SpecialistSignUpViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        passData()
        setUpObservers()
        onClick()

    }

    private fun onClick() {
        binding.apply {

            regSpecialistContinue.setOnClickListener{
                viewModel.navigateToSpecialistMoreDetails()

            }
            specialistregsignIn.setOnClickListener{
                viewModel.navigateToSpecialistSignIn()
            }


        }

    }
    private fun passData() {
    }
    private fun setUpObservers() {
        viewModel.uiState.observe(viewLifecycleOwner) {
            when (it) {
                SpecialistSignUpUIState.Loading ->{}  //renderLoading()
                is SpecialistSignUpUIState.Error -> {
                    //renderError(errorTitle = it.title, errorMessage = it.message)
                }
                else -> {}
            }
        }
        viewModel.interactions.observeEvent(viewLifecycleOwner) {
            when (it) {
                is SpecialistSignUpActions.Navigate -> findNavController().navigate(it.destination)
            }
        }
    }

}