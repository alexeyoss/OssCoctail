package ru.alexeyoss.features.coctails_list.domain.entitites

import android.net.Uri

data class UiCoctail(
    val id: Int,
    val title: String,
    val description: String?,
    val recipe: String?,
    val photo: Uri
)
