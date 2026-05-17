package com.example.nallnudi.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "terms")
data class TermEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val englishWord: String,

    val kannadaMeaning: String,

    val example: String,

    val subject: String
)