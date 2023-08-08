package ru.alexeyoss.services.storage.coctails

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.alexeyoss.services.storage.BuildConfig
import ru.alexeyoss.services.storage.coctails.converters.PhotoUriConverter
import ru.alexeyoss.services.storage.coctails.entitites.CoctailsDTO

@Database(
    entities = [
        CoctailsDTO::class
    ],
    version = BuildConfig.DB_VERSION,
    exportSchema = false
)
@TypeConverters(PhotoUriConverter::class)
abstract class CoctailsDb : RoomDatabase() {
    abstract fun coctailsDao(): CoctailsDao

    companion object {
        @Volatile
        private var instance: CoctailsDb? = null

        fun getInstance(context: Context): CoctailsDb {
            return instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context): CoctailsDb {
            val databaseBuilder = Room.databaseBuilder(context, CoctailsDb::class.java, BuildConfig.DB_NAME)
//            CoctailsDb.addMigrations(databaseBuilder, context)
            if (BuildConfig.DEBUG) {
                databaseBuilder.fallbackToDestructiveMigration()
            }
            return databaseBuilder.build()
        }

    }
}