package com.example.autoexpense.data.storage

import android.content.Context
import com.example.autoexpense.data.storage.models.Auto
import javax.inject.Inject

private const val AUTO_INFO_SHARED_PREFS_NAME = "auto_info_shared_prefs_name"

private const val KEY_BRAND = "brand"
private const val KEY_MODEL = "model"
private const val KEY_MILEAGE = "mileage"
private const val KEY_POWER = "power"
private const val KEY_FUEL_TYPE = "fuelType"
private const val KEY_YEAR = "year"

private const val DEFAULT_BRAND_VALUE = "Default brand"
private const val DEFAULT_MODEL_VALUE = "Default model"
private const val DEFAULT_MILEAGE_VALUE = 0
private const val DEFAULT_POWER_VALUE = 0
private const val DEFAULT_FUEL_TYPE_VALUE = "Default fuelType"
private const val DEFAULT_YEAR_VALUE = 1973

class AutoInfoStorageImpl  @Inject constructor(context: Context) : AutoInfoStorage {

    private val sharedPreferences =
        context.getSharedPreferences(AUTO_INFO_SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun edit(auto: Auto): Boolean {
        sharedPreferences.edit().putString(KEY_BRAND, auto.brand).apply()
        sharedPreferences.edit().putString(KEY_MODEL, auto.model).apply()
        sharedPreferences.edit().putInt(KEY_MILEAGE, auto.mileage).apply()
        sharedPreferences.edit().putInt(KEY_POWER, auto.power).apply()
        sharedPreferences.edit().putString(KEY_FUEL_TYPE, auto.fuelType).apply()
        sharedPreferences.edit().putInt(KEY_YEAR, auto.year).apply()
        return true
    }

    override fun get(): Auto {
        val brand =
            sharedPreferences.getString(KEY_BRAND, DEFAULT_BRAND_VALUE) ?: DEFAULT_BRAND_VALUE
        val model =
            sharedPreferences.getString(KEY_MODEL, DEFAULT_MODEL_VALUE) ?: DEFAULT_MODEL_VALUE
        val mileage =
            sharedPreferences.getInt(KEY_MILEAGE, DEFAULT_MILEAGE_VALUE)
        val power = sharedPreferences.getInt(KEY_POWER, DEFAULT_POWER_VALUE)
        val fuelType = sharedPreferences.getString(KEY_FUEL_TYPE, DEFAULT_FUEL_TYPE_VALUE)
            ?: DEFAULT_FUEL_TYPE_VALUE
        val year = sharedPreferences.getInt(KEY_YEAR, DEFAULT_YEAR_VALUE)
        return Auto(
            brand = brand,
            model = model,
            mileage = mileage,
            power = power,
            fuelType = fuelType,
            year = year
        )
    }
}