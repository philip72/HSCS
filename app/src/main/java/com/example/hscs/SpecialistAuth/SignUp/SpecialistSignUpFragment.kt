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
import com.example.hscs.dataClass.specialist
import com.example.hscs.databinding.FragmentPatientSignUpBinding
import com.example.hscs.databinding.FragmentSpecialistSignUpBinding
import com.example.hscs.util.observeEvent
import com.example.hscs.util.viewBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import org.koin.androidx.viewmodel.ext.android.viewModel

class SpecialistSignUpFragment : Fragment(R.layout.fragment_specialist_sign_up) {

    private val binding by viewBinding(FragmentSpecialistSignUpBinding::bind)
    private val viewModel: SpecialistSignUpViewModel by viewModel()
    private lateinit var database: DatabaseReference


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        passData()
        registerSpecialist()
        setUpObservers()
        onClick()

    }
    private fun registerSpecialist(){
        binding.SpecialistRegister.setOnClickListener {
            val specialistFirstName=binding.specialistFirstName.text.toString()
            val specialistLastName= binding.SpecialistLastName.text.toString()
            val specialistEmail=binding.specialistRegEmail.text.toString()
            val specialistPhoneNumber=binding.specialistPhoneNo.text.toString()
            val specialistPassword=binding.specialistPassword.text.toString()
            val specialistHospitalId=binding.HospitalId.text.toString()
            val specialistProfessionPractised=binding.ProfessionPractisec.text.toString()
            val specialistYearsOfExperience=binding.YearsOfExp.text.toString()
            val specialistAge=binding.Age.text.toString()
            val specialistHospitalPractised= binding.hospitalPractising.text.toString()

            database=FirebaseDatabase.getInstance().getReference("Specialists")
            val Specialist=specialist(specialistFirstName,specialistLastName,specialistEmail,specialistPhoneNumber,specialistPassword,specialistHospitalId,specialistProfessionPractised,specialistYearsOfExperience,specialistAge,specialistHospitalPractised)

            database.child(specialistProfessionPractised).setValue(Specialist).addOnSuccessListener {
                binding.specialistFirstName.text?.clear()
                binding.SpecialistLastName.text?.clear()
                binding.specialistRegEmail.text?.clear()
                binding.specialistPhoneNo.text?.clear()
                binding.specialistPassword.text?.clear()
                binding.HospitalId.text?.clear()
                binding.ProfessionPractisec.text?.clear()
                binding.YearsOfExp.text?.clear()
                binding.Age.text?.clear()
                binding.hospitalPractising.text?.clear()
            }
            viewModel.navigateToSpecialistTextPage()
        }

    }
    private fun onClick() {
        binding.apply {


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