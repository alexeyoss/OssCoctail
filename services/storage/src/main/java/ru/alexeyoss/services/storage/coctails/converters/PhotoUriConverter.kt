package ru.alexeyoss.services.storage.coctails.converters

import android.net.Uri
import androidx.room.TypeConverter

/**
 * Конвертер для  [Uri]
 * Объект [Uri] не может сохраниться в БД, поэтому его следует
 * конвертировать в объект String
 */
class PhotoUriConverter {

    companion object {

        private const val SEPARATOR = ", "
    }

    @TypeConverter
    fun toString(photo: Uri): String {
        return photo.toString()
    }

    @TypeConverter
    fun toPhotosList(rawString: String): Uri {
        return Uri.parse(rawString)

    }
}