package com.example.abschlussaufgabe.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.abschlussaufgabe.data.Apprepository

import com.example.abschlussaufgabe.remote.Repository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository = Apprepository()

    val ghosts = repository.ghostList

    init {
        repository.loadGhosts()
    }

    //score
    val _score = MutableLiveData(0)
    val score: LiveData<Int>
        get() = _score


}