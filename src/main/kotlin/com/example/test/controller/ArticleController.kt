package com.example.test.controller

import com.example.test.model.Article
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("/api/v1/articles")
class ArticleController {

    val articles = mutableListOf<Article>(
        Article(title = "My Title", content = "My content")
    )

    @GetMapping
    fun articles(): MutableList<Article> {
        return articles
    }

    @GetMapping("/{slug}")
    fun articles(@PathVariable slug: String): Article {
        return articles.find { article -> article.slug == slug } ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    @PostMapping
    fun newArticle(@RequestBody article: Article): Article {
        articles.add(article)
        return article
    }

    @PutMapping("/{slug}")
    fun updateArticle(@RequestBody article: Article, @PathVariable slug: String): Article {
        val existingArticle = articles.find { it.slug == slug } ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
        existingArticle.content = article.content
        return article
    }

    @DeleteMapping("/{slug}")
    fun deleteArticle(@PathVariable slug: String){
        articles.removeIf { article -> article.slug == slug }
    }
}