package com.example.hscs.PatientAuth.SignIn

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.hscs.R
import com.example.hscs.databinding.FragmentPatientSignInBinding
import com.example.hscs.util.observeEvent
import com.example.hscs.util.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class PatientSignInFragment : Fragment(R.layout.fragment_patient_sign_in) {

    private val binding by viewBinding(FragmentPatientSignInBinding::bind)
    private val viewModel: PatientSignInViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        passData()
        setUpObservers()
        onClick()

    }

    private fun onClick() {
        binding.apply {

            actionSignInPatient.setOnClickListener{
                viewModel.navigateToSpecialistPage()

            }
            patientsignUp.setOnClickListener{
                viewModel.navigateToPatientSignUp()
            }


        }

    }




    private fun passData() {

    }

    private fun setUpObservers() {
        viewModel.uiState.observe(viewLifecycleOwner) {
            when (it) {
                PatientSignInUIState.Loading ->{}  //renderLoading()
                is PatientSignInUIState.Error -> {
                    //renderError(errorTitle = it.title, errorMessage = it.message)
                }
                else -> {}
            }
        }

        viewModel.interactions.observeEvent(viewLifecycleOwner) {
            when (it) {
                is PatientSignInActions.Navigate -> findNavController().navigate(it.destination)
            }
        }
    }
}