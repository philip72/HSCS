package com.example.hscs.di

import com.example.hscs.PatientAuth.SignIn.PatientSignInViewModel
import com.example.hscs.choosing.ChoosingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val choosingModule = module {
    viewModel { ChoosingViewModel() }
}