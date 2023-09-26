package com.example.autoexpense.presentation.auto.editAutoInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment
import com.example.autoexpense.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditAutoInfoFragment : Fragment() {

    private val editAutoInfoViewModel by viewModels<EditAutoInfoViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edit_auto_info, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = NavHostFragment.findNavController(this)

        val cancelBtn: Button = view.findViewById(R.id.cancelBtn)
        val saveBtn: Button = view.findViewById(R.id.saveBtn)
        val editBrand: EditText = view.findViewById(R.id.brandEdit)
        val editModel: EditText = view.findViewById(R.id.modelEdit)
        val editMileage: EditText = view.findViewById(R.id.mileageEdit)
        val editPower: EditText = view.findViewById(R.id.powerEdit)
        val editFuelType: EditText = view.findViewById(R.id.fuelTypeEdit)
        val editYear: EditText = view.findViewById(R.id.yearEdit)

        saveBtn.setOnClickListener {
            val brandText = editBrand.text.toString()
            val modelText = editModel.text.toString()
            val fuelTypeText = editFuelType.text.toString()

            var mileageText: Int? = null
            var powerText: Int? = null
            var yearText: Int? = null

            try {
                mileageText = editMileage.text.toString().toInt()
                powerText = editPower.text.toString().toInt()
                yearText = editYear.text.toString().toInt()
            } catch (e: NumberFormatException) {
                val toast = Toast.makeText(requireContext(), "Error", Toast.LENGTH_SHORT)
                toast.show()
            }

            if (mileageText != null && powerText != null && yearText != null) {
                editAutoInfoViewModel.editAutoInfo(
                    brandText,
                    modelText,
                    mileageText,
                    powerText,
                    fuelTypeText,
                    yearText
                )
                navController.navigate(R.id.action_editAutoInfoFragment_to_autoInfoFragment)
            } else {
                val toast =
                    Toast.makeText(requireContext(), "Заполните все поля", Toast.LENGTH_SHORT)
                toast.show()
            }
        }

        cancelBtn.setOnClickListener {
            navController.popBackStack()
        }
    }
}