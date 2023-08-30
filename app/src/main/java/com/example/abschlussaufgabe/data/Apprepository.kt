package com.example.abschlussaufgabe.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.abschlussaufgabe.R
import com.example.abschlussaufgabe.data.model.Ghost
import com.example.abschlussaufgabe.data.model.Score
import com.example.abschlussaufgabe.local.ScoreDatabase


const val TAG = "Repository"

class Apprepository(private val database: ScoreDatabase) {

    private val _ghostList = MutableLiveData<List<Ghost>>()
    val ghostList: LiveData<List<Ghost>>
        get() = _ghostList



    init {
        loadGhosts()
    }




    fun loadGhosts(){
        _ghostList.value = listOf<Ghost>(
            Ghost(0,R.string.ghost1,R.string.g1description,R.drawable.mimic),
            Ghost(1,R.string.ghost2,R.string.g2description,R.drawable.shadow),
            Ghost(2,R.string.ghost3,R.string.g3description,R.drawable.lucy),
            Ghost(3,R.string.ghost4,R.string.g4description,R.drawable.casper),
            Ghost(4,R.string.ghost6,R.string.g6description,R.drawable.ermi),
        )
    }

    //------------------db Score---------------------


    val guestList: LiveData<List<Score>> = database.scoreDatabaseDao.getAll()

    suspend fun insert(score: Score) {
        try {
            database.scoreDatabaseDao.insert(score)
        } catch (e: Exception) {
            Log.e(TAG,"Failed to insert into database: $e")
        }
    }

    suspend fun update(userUid: String, score:Int) {

        try {
            database.scoreDatabaseDao.update(userUid,score)

        } catch (e: Exception) {
            Log.e(TAG,"Failed to update database: $e")
        }

    }


    suspend fun delete(score: Score) {
        try {
            database.scoreDatabaseDao.deleteById(score.id)
        } catch (e: Exception) {
            Log.e(TAG, "Failed to delete from database: $e")
        }
    }

    /*suspend fun getById(userUid:String) :Score{
        var b = Score(1,"user1", 0)


        try{
            b = database.scoreDatabaseDao.getById(userUid).first()
            database.scoreDatabaseDao.getById(userUid)
        }catch (e:Exception){
            Log.e(TAG, "Failed to delete from database: $e")
        }
        return b
    }
*/



}