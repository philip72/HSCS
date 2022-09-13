package com.example.hscs.di

import com.example.hscs.PatientAuth.SignIn.PatientSignInViewModel
import com.example.hscs.SpecialistAuth.SignUp.SpecialistSignUpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val specialistSignUpModule = module {

    viewModel { SpecialistSignUpViewModel() }
}