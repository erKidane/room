package com.example.abschlussaufgabe.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Score(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val userUid:String,
    var score: Int = 0
)
