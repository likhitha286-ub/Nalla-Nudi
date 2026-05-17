package com.example.nallnudi.data.model.db
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.nallnudi.data.model.TermEntity

@Dao
interface TermDao {

    @Insert
    suspend fun insertWords(words: List<TermEntity>)

    @Query("SELECT * FROM terms")
    suspend fun getAllWords(): List<TermEntity>

    @Query(
        "SELECT * FROM terms WHERE subject = :subject AND englishWord LIKE '%' || :query || '%'"
    )
    suspend fun searchBySubject(
        subject: String,
        query: String
    ): List<TermEntity>
}