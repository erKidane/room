package com.example.abschlussaufgabe.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.abschlussaufgabe.data.model.Score


@Database(entities = [Score::class], version = 1)
abstract class ScoreDatabase: RoomDatabase() {
    abstract val scoreDatabaseDao: ScoreDatabaseDao
}

private lateinit var INSTANCE: ScoreDatabase

fun getDatabase(context: Context): ScoreDatabase {
    synchronized(ScoreDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                ScoreDatabase::class.java,
                "score_database"
            )
                .build()
        }
    }
    return INSTANCE
}