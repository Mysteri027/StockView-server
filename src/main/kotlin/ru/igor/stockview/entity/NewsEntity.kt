package ru.igor.stockview.entity

import jakarta.persistence.*

@Entity
@Table(name = "news")
class NewsEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        val id: Int = 0,

        @Column(name = "title")
        val title: String = "",

        @Column(name = "description")
        val description: String = "",

        @Column(name = "news_link")
        val newsLink: String = "",

        @Column(name = "image_link")
        val imageLink: String = ""
)