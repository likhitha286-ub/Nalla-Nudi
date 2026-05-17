package com.example.nallnudi.utils
import android.content.Context
import androidx.room.Room
import com.example.nallnudi.data.model.db.AppDatabase

object DatabaseProvider {

    private var database: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase {

        if (database == null) {

            database = Room.databaseBuilder(
                context,
                AppDatabase::class.java,
                "nalla_nudi_db"
            ).build()
        }

        return database!!
    }
}
