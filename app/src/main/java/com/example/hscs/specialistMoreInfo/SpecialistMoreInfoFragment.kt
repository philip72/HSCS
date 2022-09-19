package com.example.hscs.specialistMoreInfo

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hscs.R

class SpecialistMoreInfoFragment : Fragment() {

    companion object {
        fun newInstance() = SpecialistMoreInfoFragment()
    }

    private lateinit var viewModel: SpecialistMoreInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_specialist_more_info, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SpecialistMoreInfoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}