package com.example.nallnudi.data.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nallnudi.data.model.TermEntity

@Database(
    entities = [TermEntity::class],
    version = 1
)

abstract class AppDatabase : RoomDatabase() {

    abstract fun termDao(): TermDao
}