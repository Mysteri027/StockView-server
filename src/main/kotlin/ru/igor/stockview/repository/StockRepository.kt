package ru.igor.stockview.repository

import org.springframework.data.repository.CrudRepository
import ru.igor.stockview.entity.StockEntity


interface StockRepository : CrudRepository<StockEntity, Int> {
    fun findByName(name: String): StockEntity?
}