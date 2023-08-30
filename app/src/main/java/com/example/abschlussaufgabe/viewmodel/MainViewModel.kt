package com.example.abschlussaufgabe.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.abschlussaufgabe.data.Apprepository
import com.example.abschlussaufgabe.data.model.Score
import com.example.abschlussaufgabe.local.getDatabase

import com.example.abschlussaufgabe.remote.Repository
import kotlinx.coroutines.launch
import okhttp3.internal.userAgent

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val  database = getDatabase(application)

    private val repository = Apprepository(database)

    val ghosts = repository.ghostList

    val scoreFill: Score = Score(1,"user1",0)

    val _score = MutableLiveData<Score>()
    val score: LiveData<Score>
        get() = _score

    init {
        viewModelScope.launch{
            repository.loadGhosts()
            insertScore(scoreFill)
            getByScoreId()
        }

    }

    //score




    fun insertScore(score: Score) {
        viewModelScope.launch {
            repository.insert(scoreFill)
        }
    }

    fun updateScore(score: Int, id:Int) {
        viewModelScope.launch {
            repository.update(score,id)
        }
    }

    fun getByScoreId(){

        viewModelScope.launch {
            _score.value = repository.getById("user1")
        }
    }





}