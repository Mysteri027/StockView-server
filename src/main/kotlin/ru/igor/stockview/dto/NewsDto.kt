package ru.igor.stockview.dto

data class NewsDto(
        val id: Int? = null,
        val title: String,
        val description: String,
        val newsLink: String,
        val imageLink: String,
)