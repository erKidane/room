package com.example.abschlussaufgabe.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.abschlussaufgabe.remote.MealApi
import com.example.abschlussaufgabe.remote.Repository
import kotlinx.coroutines.launch

class MealViewModel: ViewModel() {

    private val repo = Repository(MealApi)

    init {
        getRandomMeal()
    }

    val randomMeal = repo.randomMeal

    fun getRandomMeal() {
        viewModelScope.launch {
            repo.getRandomMeal()
        }
    }



}