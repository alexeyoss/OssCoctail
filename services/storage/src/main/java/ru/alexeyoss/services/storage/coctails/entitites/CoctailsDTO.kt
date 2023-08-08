package ru.alexeyoss.services.storage.coctails.entitites

import android.net.Uri
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(
    tableName = "coctails"
)
@Parcelize
data class CoctailsDTO(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val description: String?,
    val recipe: String?,
    val photo: Uri
) : Parcelable
