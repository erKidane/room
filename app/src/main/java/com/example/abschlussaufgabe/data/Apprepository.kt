package com.example.abschlussaufgabe.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.data.model.Ghost


class Apprepository {

    private val _ghostList = MutableLiveData<List<Ghost>>()
    val ghostList: LiveData<List<Ghost>>
        get() = _ghostList


    init {
        loadGhosts()
    }




    fun loadGhosts(){
        _ghostList.value = listOf<Ghost>(
            Ghost(R.string.ghost1,R.string.g1description,R.drawable.bild3),
            Ghost(R.string.ghost2,R.string.g2description,R.drawable.bild3),
            Ghost(R.string.ghost3,R.string.g3description,R.drawable.bild3),
            Ghost(R.string.ghost4,R.string.g4description,R.drawable.bild3),
            Ghost(R.string.ghost5,R.string.g5description,R.drawable.bild3),
            Ghost(R.string.ghost6,R.string.g6description,R.drawable.bild3),
        )
    }
}