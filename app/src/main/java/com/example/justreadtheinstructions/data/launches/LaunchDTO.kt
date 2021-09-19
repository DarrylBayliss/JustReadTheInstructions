package com.example.justreadtheinstructions.data.launches

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LaunchDTO(
    val name: String,
    val details: String?,
    @Json(name = "date_utc") val date: String,
    val links: LinksDTO,
)

@JsonClass(generateAdapter = true)
data class LinksDTO(
    val patch: PatchDTO,
    val webcast: String?
)

@JsonClass(generateAdapter = true)
data class PatchDTO(
    val small: String?,
    val large: String?
)
