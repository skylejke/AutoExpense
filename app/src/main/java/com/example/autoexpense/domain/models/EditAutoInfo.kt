package com.example.autoexpense.domain.models

data class EditAutoInfo(
    val brand: String,
    val model: String,
    val mileage: Int,
    val power: Int,
    val fuelType: String,
    val year: Int
)
