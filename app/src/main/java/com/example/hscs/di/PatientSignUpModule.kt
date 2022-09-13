package com.example.hscs.di

import com.example.hscs.PatientAuth.SignIn.PatientSignInViewModel
import com.example.hscs.PatientAuth.SignUp.PatientSignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val patientSignUpModule = module {
    viewModel { PatientSignUpViewModel() }
}