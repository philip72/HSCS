package com.example.hscs.di

import com.example.hscs.PatientAuth.SignIn.PatientSignInViewModel
import com.example.hscs.SpecialistAuth.SignUp.SpecialistSignUpViewModel
import com.example.hscs.patientClicked.PatientClickedViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val patientClickedModule = module {

    viewModel { PatientClickedViewModel() }
}