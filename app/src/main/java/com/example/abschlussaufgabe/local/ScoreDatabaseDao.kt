package com.example.abschlussaufgabe.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.abschlussaufgabe.data.model.Score

@Dao
interface ScoreDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(score:Score)

    @Query("UPDATE Score SET score = :score WHERE userUid = :userUid")
    suspend fun update(userUid: String, score: Int)

    @Query("SELECT * FROM Score")
    fun getAll(): LiveData<List<Score>>

    @Query("SELECT * FROM Score WHERE userUid = :userUid")
    suspend fun getById(userUid: String): List<Score>

    @Query("DELETE FROM Score WHERE id = :id")
    suspend fun deleteById(id: Int)

    @Query("DELETE FROM Score")
    suspend fun deleteAll()
}