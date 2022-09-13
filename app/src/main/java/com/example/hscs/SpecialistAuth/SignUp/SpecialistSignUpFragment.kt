package com.example.hscs.SpecialistAuth.SignUp

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hscs.R

class SpecialistSignUpFragment : Fragment() {

    companion object {
        fun newInstance() = SpecialistSignUpFragment()
    }

    private lateinit var viewModel: SpecialistSignUpViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_specialist_sign_up, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SpecialistSignUpViewModel::class.java)
        // TODO: Use the ViewModel
    }

}