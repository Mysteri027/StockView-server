package ru.igor.stockview.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.igor.stockview.dto.NewsDto
import ru.igor.stockview.service.NewsService

@RestController
@RequestMapping("/news")
class NewsController(private val newsService: NewsService) {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFoundException(e: NoSuchElementException): ResponseEntity<Map<String, String?>> {
        return ResponseEntity(mapOf("message" to e.message), HttpStatus.NOT_FOUND)
    }

    @GetMapping("")
    fun getAllNews() = newsService.getAllNews()

    @GetMapping("{id}")
    fun getNewById(@PathVariable("id") id: Int): NewsDto = newsService.getById(id)
}