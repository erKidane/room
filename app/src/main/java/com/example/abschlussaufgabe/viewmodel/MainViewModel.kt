package com.example.abschlussaufgabe.viewmodel

import androidx.lifecycle.ViewModel
import com.example.abschlussaufgabe.data.Apprepository

class MainViewModel: ViewModel() {

    private val repository = Apprepository()

    val ghosts = repository.ghostList

    init {
        repository.loadGhosts()
    }

}