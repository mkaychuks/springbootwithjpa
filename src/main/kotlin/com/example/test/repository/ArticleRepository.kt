package com.example.test.repository

import com.example.test.entity.Article
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface ArticleRepository: JpaRepository<Article, Long> {
    fun findAllByOrderByCreatedAtDesc(): Iterable<Article>
    fun findBySlug(slug: String): Optional<Article>
}