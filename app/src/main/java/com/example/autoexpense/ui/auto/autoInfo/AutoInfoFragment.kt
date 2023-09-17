package com.example.autoexpense.ui.auto.autoInfo

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.autoexpense.R

class AutoInfoFragment : Fragment() {

    private lateinit var autoInfoViewModel: AutoInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_auto_info, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        autoInfoViewModel = ViewModelProvider(
            this,
            AutoInfoViewModelFactory(requireContext())
        )[AutoInfoViewModel::class.java]

        val navController = NavHostFragment.findNavController(this)

        val editAutoInfoBtn: Button = view.findViewById(R.id.editBtn)
        val nameText: TextView = view.findViewById(R.id.name)
        val mileageText: TextView = view.findViewById(R.id.mileage)
        val powerText: TextView = view.findViewById(R.id.power)
        val fuelTypeText: TextView = view.findViewById(R.id.fuel)
        val yearText: TextView = view.findViewById(R.id.year)

        autoInfoViewModel.autoInfoLiveData.observe(viewLifecycleOwner) {
            nameText.text = "${it.brand} ${it.model}"
            mileageText.text = "${it.mileage}"
            powerText.text = "${it.power}"
            fuelTypeText.text = it.fuelType
            yearText.text = "${it.year}"
        }

        autoInfoViewModel.get()

        editAutoInfoBtn.setOnClickListener {
            navController.navigate(R.id.action_autoInfoFragment_to_editAutoInfoFragment)
        }
    }
}