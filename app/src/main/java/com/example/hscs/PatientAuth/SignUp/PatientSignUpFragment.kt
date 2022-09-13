package com.example.hscs.PatientAuth.SignUp

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hscs.R

class PatientSignUpFragment : Fragment() {

    companion object {
        fun newInstance() = PatientSignUpFragment()
    }

    private lateinit var viewModel: PatientSignUpViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_patient_sign_up, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PatientSignUpViewModel::class.java)
        // TODO: Use the ViewModel
    }

}