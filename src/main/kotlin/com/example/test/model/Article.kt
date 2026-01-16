package com.example.test.model

import java.time.LocalDateTime
import java.util.Locale

private fun String.toSlug() : String {
    return lowercase(Locale.getDefault())
        .replace("\n", " ")
        .replace("[^a-z\\d\\s]".toRegex(), " ")
        .split(" ")
        .joinToString("-")
        .replace("-+".toRegex(), "-")
}

data class Article(
    val title: String?,
    var content: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val slug: String? = title?.toSlug()
)
