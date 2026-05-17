package com.example.nallnudi.data.model
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "saved_words")
data class SavedWord(

    @PrimaryKey
    val word: String
)