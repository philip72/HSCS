package com.example.hscs.di

import com.example.hscs.PatientAuth.SignIn.PatientSignInViewModel
import com.example.hscs.SpecialistAuth.SignUp.SpecialistSignUpViewModel
import com.example.hscs.specialistTextPage.SpecialistTextPageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val specialistTextPageModule = module {

    viewModel { SpecialistTextPageViewModel() }
}