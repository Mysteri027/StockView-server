package ru.igor.stockview.dto.news

import ru.igor.stockview.entity.NewsEntity

data class NewsDto(
    val id: Int? = null,
    val title: String,
    val description: String,
    val newsLink: String,
    val imageLink: String,
) {
    fun toEntity(): NewsEntity {
        return NewsEntity(
            id = 0,
            title = this.title,
            description = this.description,
            newsLink = this.newsLink,
            imageLink = this.imageLink,
        )
    }
}