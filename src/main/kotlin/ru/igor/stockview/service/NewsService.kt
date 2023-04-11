package ru.igor.stockview.service

import org.springframework.stereotype.Service
import ru.igor.stockview.dto.NewsDto

@Service
interface NewsService {
    fun getAllNews(): List<NewsDto>
}