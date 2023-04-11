package ru.igor.stockview.repository

import org.springframework.data.repository.CrudRepository
import ru.igor.stockview.entity.NewsEntity

interface NewsRepository : CrudRepository<NewsEntity, Int>