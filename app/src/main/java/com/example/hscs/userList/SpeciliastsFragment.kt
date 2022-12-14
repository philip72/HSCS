package com.example.hscs.userList

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hscs.R

class SpeciliastsFragment : Fragment(R.layout.fragment_speciliasts) {

    companion object {
        fun newInstance() = SpeciliastsFragment()
    }

    private lateinit var viewModel: SpeciliastsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_speciliasts, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SpeciliastsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}