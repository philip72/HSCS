package com.example.hscs.PatientAuth.SignUp

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.hscs.R
import com.example.hscs.databinding.FragmentPatientSignUpBinding
import com.example.hscs.databinding.FragmentSpecialistSignUpBinding
import com.example.hscs.util.observeEvent
import com.example.hscs.util.viewBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class PatientSignUpFragment : Fragment(R.layout.fragment_patient_sign_up) {

    private val binding by viewBinding(FragmentPatientSignUpBinding::bind)
    private val viewModel: PatientSignUpViewModel by viewModel()
    lateinit var auth: FirebaseAuth

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()
        passData()
        setUpObservers()
      //  onClick()
        registerUser()

    }

    private fun registerUser() {
        binding.apply {
            regPatientContinue.setOnClickListener {
                val firstname = binding.firtName.text.toString().trim()
                val lastname = binding.lastName.text.toString().trim()
                val  email = binding.regEmail.text.toString().trim()
                val  phone = binding.phoneNo.text.toString().trim()
                val  password = binding.password.text.toString().trim()

                reg(email, password)

            }

        }





    }

    private fun reg(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener{
                if (!it.isSuccessful)  return@addOnCompleteListener
                    // If sign in fails, display a message to the user.

                    viewModel.navigateToPatientSignIn()


            }
            .addOnFailureListener {
                viewModel.navigateToPatientSignIn()


            }
    }

    private fun updateUI(user: FirebaseUser?) {
        TODO("Not yet implemented")
    }
/*

    private fun onClick() {
        binding.apply {

            regPatientContinue.setOnClickListener{
                viewModel.navigateToSpecialistPage(
                    firstname = firtName.text.toString().trim(),
                    lastname = lastName.text.toString().trim(),
                    email = regEmail.text.toString().trim(),
                    phone = phoneNo.text.toString().trim(),
                    password = password.text.toString().trim()


                )

            }
            patsignIn.setOnClickListener{
                viewModel.navigateToPatientSignIn()
            }


        }

    }
*/




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