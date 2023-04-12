package ru.igor.stockview.service.impl

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import ru.igor.stockview.dto.NewsDto
import ru.igor.stockview.repository.NewsRepository
import ru.igor.stockview.service.NewsService

@Service
class NewsServiceImpl(
    private val newsRepository: NewsRepository
) : NewsService {
    override fun getAllNews(): List<NewsDto> {
        val newsList = newsRepository.findAll().map { it.toDto() }
        return newsList.ifEmpty { throw NoSuchElementException("News list is empty") }
    }

    override fun getById(id: Int): NewsDto {
        return newsRepository.findByIdOrNull(id)
            ?.toDto()
            ?: throw NoSuchElementException("News with id $id not found")
    }

    override fun addNews(newsDto: NewsDto): Int {
        return newsRepository.save(newsDto.toEntity()).id
    }

    override fun deleteAllNews() {
        newsRepository.deleteAll()
    }

    override fun addNewsList(newsList: List<NewsDto>): Int {
        newsRepository.saveAll(newsList.map { it.toEntity() })
        return newsList.size
    }
}