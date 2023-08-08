package ru.alexeyoss.services.storage.coctails

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import ru.alexeyoss.services.storage.coctails.entitites.CoctailsDTO

/**
 * Интерфейс для работы с БД с преступлениями
 */
@Dao
interface CoctailsDao {

    @Query("SELECT * FROM coctails")
    suspend fun getAll(): List<CoctailsDTO>

    @Insert(onConflict = REPLACE)
    suspend fun saveAll(coctails: List<CoctailsDTO>)

    @Insert(onConflict = REPLACE)
    suspend fun save(coctail: CoctailsDTO)

    @Query("DELETE FROM coctails")
    suspend fun deleteAll()

}