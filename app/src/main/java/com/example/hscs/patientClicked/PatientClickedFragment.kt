package com.example.hscs.patientClicked

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hscs.R

class PatientClickedFragment : Fragment() {

    companion object {
        fun newInstance() = PatientClickedFragment()
    }

    private lateinit var viewModel: PatientClickedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_patient_clicked, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PatientClickedViewModel::class.java)
        // TODO: Use the ViewModel
    }

}