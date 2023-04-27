package ru.igor.stockview.repository

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import ru.igor.stockview.entity.StockEntity


interface StockRepository : CrudRepository<StockEntity, Int> {

    @Query(value = "SELECT s FROM StockEntity s where s.name = :name")
    fun findByName(@Param("name") name: String): StockEntity?

    @Query(value = "SELECT s FROM StockEntity s where s.ticker = :ticker")
    fun findByTicker(@Param("ticker") ticker: String): StockEntity?
}