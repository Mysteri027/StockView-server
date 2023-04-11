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

    override fun getById(id: Int): NewsDto {
        return newsRepository.findByIdOrNull(id)
            ?.toDto()
            ?: throw NoSuchElementException("New with id $id not found")
    }

    override fun addNews(newsDto: NewsDto): Int {
        return newsRepository.save(newsDto.toEntity()).id
    }

    override fun addNewsList(newsList: List<NewsDto>) {
        newsRepository.saveAll(newsList.map { it.toEntity() })
    }

    private fun NewsEntity.toDto(): NewsDto {
        return NewsDto(
            id = this.id,
            title = this.title,
            description = this.description,
            newsLink = this.newsLink,
            imageLink = this.imageLink
        )
    }

    private fun NewsDto.toEntity(): NewsEntity {
        return NewsEntity(
            id = 0,
            title = this.title,
            description = this.description,
            newsLink = this.newsLink,
            imageLink = this.imageLink,
        )
    }
}