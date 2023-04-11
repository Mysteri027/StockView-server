package ru.igor.stockview.service.impl

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import ru.igor.stockview.dto.NewsDto
import ru.igor.stockview.entity.NewsEntity
import ru.igor.stockview.repository.NewsRepository
import ru.igor.stockview.service.NewsService

@Service
class NewsServiceImpl(
    private val newsRepository: NewsRepository
) : NewsService {
    override fun getAllNews(): List<NewsDto> = newsRepository.findAll().map { it.toDto() }


    private fun NewsEntity.toDto(): NewsDto {
        return NewsDto(
            id = this.id,
            title = this.title,
            description = this.description,
            newsLink = this.newsLink,
            imageLink = this.imageLink
        )
    }

    override fun getById(id: Int): NewsDto {
        return newsRepository.findByIdOrNull(id)
            ?.toDto()
            ?: throw NoSuchElementException("New with id $id not found")
    }
}