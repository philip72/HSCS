package com.example.hscs.selectedPatient

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hscs.R

class SelectedPatientFragment : Fragment(R.layout.fragment_selected_patient) {

    companion object {
        fun newInstance() = SelectedPatientFragment()
    }

    private lateinit var viewModel: SelectedPatientViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_selected_patient, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SelectedPatientViewModel::class.java)
        // TODO: Use the ViewModel
    }

}