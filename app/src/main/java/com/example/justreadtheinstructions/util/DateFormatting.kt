package com.example.justreadtheinstructions.util

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

object DateFormatting {

    fun launchDate(date: String): String {
        return ZonedDateTime.parse(date)
            .format(
                DateTimeFormatter.ofPattern(
                    "EEE MMM d HH:mm:ss yyyy"
                )
            )
    }
}