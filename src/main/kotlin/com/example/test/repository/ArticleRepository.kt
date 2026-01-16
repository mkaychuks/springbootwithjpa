package com.example.test.repository

import com.example.test.entity.Article
import org.springframework.data.jpa.repository.JpaRepository

interface ArticleRepository: JpaRepository<Article, Long> {
    fun findAllByOrderByCreatedAtDesc(): Iterable<Article>
}