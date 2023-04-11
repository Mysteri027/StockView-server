package ru.igor.stockview.controller

import org.springframework.web.bind.annotation.*
import ru.igor.stockview.service.NewsService

@RestController
@RequestMapping("/news")
class NewsController(private val newsService: NewsService) {

    @GetMapping("")
    fun getAllNews() = newsService.getAllNews()

}