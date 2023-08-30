package com.example.abschlussaufgabe.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.abschlussaufgabe.data.Apprepository
import com.example.abschlussaufgabe.data.model.Score
import com.example.abschlussaufgabe.local.getDatabase
import kotlinx.coroutines.launch


class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val  database = getDatabase(application)

    private val repository = Apprepository(database)

    val ghosts = repository.ghostList



    fun updateScore2(increaseCount:Int){

        viewModelScope.launch {
            var score2 =  database.scoreDatabaseDao.getById("user1")
            score2[0].score += increaseCount

            _scoreToShow!!.value = score2[0].score

            database.scoreDatabaseDao.update("user1",score2.first().score)
        }

    }

    val scoreFill: Score = Score(
        1,"user1",0)

    private var _scoreToShow = MutableLiveData<Int>(0)
    val scoreToShow: LiveData<Int>
        get() = _scoreToShow

    var adapterPostition: Int = 0
    var aktuelleGhostId:Int = 0

    init {
        Log.e("muuh","macht die kuh")
        viewModelScope.launch{
            repository.loadGhosts()
            insertScore()
            //getByScoreId()
        }

    }

    //score




    fun insertScore() {
        viewModelScope.launch {
            repository.insert(scoreFill)
        }
    }

    fun updateScore(userUid:String, score:Int) {
        viewModelScope.launch {
          repository.update(userUid,score)
            //getByScoreId()


        }
    }
/*
    fun getByScoreId(){

        viewModelScope.launch {
            _score.value = repository.getById("user1")
            Log.e("updaaaaate","${_score.value!!.score}")
        }

    }


*/


}