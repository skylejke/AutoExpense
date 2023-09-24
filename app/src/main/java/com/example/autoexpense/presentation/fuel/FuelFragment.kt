package com.example.autoexpense.presentation.fuel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.autoexpense.R


class FuelFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fuel, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fuelViewModel = ViewModelProvider(this)[FuelViewModel::class.java]
        val fuelText: TextView = view.findViewById(R.id.fuelText)
        fuelViewModel.fuelLiveData.observe(viewLifecycleOwner) {
            fuelText.text = it
        }
    }

}