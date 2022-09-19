package com.example.hscs.SpecialistAuth.SignIn

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.hscs.PatientAuth.SignIn.PatientSignInActions
import com.example.hscs.databinding.FragmentSpecialistSignInBinding
import com.example.hscs.util.observeEvent
import com.example.hscs.util.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SpecialistSignInFragment : Fragment() {

    private val binding by viewBinding(FragmentSpecialistSignInBinding::bind)
    private val viewModel: SpecialistSignInViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        passData()
        setUpObservers()
        onClick()

    }

    private fun onClick() {
        binding.apply {

            actionSignInSpecialist.setOnClickListener{
                viewModel.navigateToSpecialistTextPage()

            }
            SpecsignUp.setOnClickListener{
                viewModel.navigateToSpecialistSignUp()
            }


        }

    }




    private fun passData() {

    }

    private fun setUpObservers() {
        viewModel.uiState.observe(viewLifecycleOwner) {
            when (it) {
                SpecialistSigninUIState.Loading ->{}  //renderLoading()
                is SpecialistSigninUIState.Error -> {
                    //renderError(errorTitle = it.title, errorMessage = it.message)
                }
                else -> {}
            }
        }

        viewModel.interactions.observeEvent(viewLifecycleOwner) {
            when (it) {
                is SpecialistSignInActions.Navigate -> findNavController().navigate(it.destination)
            }
        }
    }

}