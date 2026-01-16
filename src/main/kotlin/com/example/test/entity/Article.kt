package com.example.test.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime
import java.util.Locale


@Entity
class Article(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
    var title: String?,
    var content: String,
    var createdAt: LocalDateTime = LocalDateTime.now(),
    var slug: String? = title?.toSlug()
)

private fun String.toSlug() : String {
    return lowercase(Locale.getDefault())
        .replace("\n", " ")
        .replace("[^a-z\\d\\s]".toRegex(), " ")
        .split(" ")
        .joinToString("-")
        .replace("-+".toRegex(), "-")
}
