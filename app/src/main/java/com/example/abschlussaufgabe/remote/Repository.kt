package com.example.abschlussaufgabe.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.abschlussaufgabe.remote.model.Meal

class Repository(private val api: MealApi) {

    private var _randomMeal = MutableLiveData<Meal>()
    val randomMeal: LiveData<Meal>
        get() = _randomMeal

    suspend fun getRandomMeal() {
        try {
            val result = api.retrofitService.getRandomMeal()
            val meal = result.meals.first()
            Log.e("ERROR", "api ready")
            _randomMeal.value = meal
        } catch (e: Exception) {
            Log.e("ERROR", "${e.message}")
        }
    }

}