package com.example.autoexpense.presentation.service

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.autoexpense.R


class ServiceFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_service, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val serviceViewModel = ViewModelProvider(this)[ServiceViewModel::class.java]
        val serviceText: TextView = view.findViewById(R.id.serviceText)
        serviceViewModel.serviceLiveData.observe(viewLifecycleOwner) {
            serviceText.text = it
        }
    }

}