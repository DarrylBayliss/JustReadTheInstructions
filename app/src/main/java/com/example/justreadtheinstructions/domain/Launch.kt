package com.example.justreadtheinstructions.domain

import android.net.Uri
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Launch(
    val name: String,
    val date: String,
    val details: String?,
    val image: Uri?,
    val webcast: Uri?
) : Parcelable