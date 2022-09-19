package com.example.hscs.PatientAuth.SignUp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.hscs.databinding.FragmentPatientSignUpBinding
import com.example.hscs.databinding.FragmentSpecialistSignUpBinding
import com.example.hscs.util.observeEvent
import com.example.hscs.util.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class PatientSignUpFragment : Fragment() {

    private val binding by viewBinding(FragmentPatientSignUpBinding::bind)
    private val viewModel: PatientSignUpViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        passData()
        setUpObservers()
        onClick()

    }

    private fun onClick() {
        binding.apply {

            regPatientContinue.setOnClickListener{
                viewModel.navigateToSpecialistPage()

            }
            patsignIn.setOnClickListener{
                viewModel.navigateToPatientSignIn()
            }


        }

    }




    private fun passData() {

    }

    private fun setUpObservers() {
        viewModel.uiState.observe(viewLifecycleOwner) {
            when (it) {
                PatientSignUpUIState.Loading ->{}  //renderLoading()
                is PatientSignUpUIState.Error -> {
                    //renderError(errorTitle = it.title, errorMessage = it.message)
                }
                else -> {}
            }
        }

        viewModel.interactions.observeEvent(viewLifecycleOwner) {
            when (it) {
                is PatientSignUpActions.Navigate -> findNavController().navigate(it.destination)
            }
        }
    }

}