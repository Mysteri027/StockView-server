package ru.igor.stockview.service

import org.springframework.stereotype.Service
import ru.igor.stockview.dto.stock.AddStockRequestDto
import ru.igor.stockview.dto.stock.StockDto

@Service
interface StockService {
    fun getAllStocks(): List<StockDto>
    fun getStockByName(name: String): StockDto

    fun getStockByTicker(ticker: String): StockDto
    fun addStock(addStockRequestDto: AddStockRequestDto)
    fun deleteAllStocks()

    fun updateStocks()

    fun addStockToFavorite(name: String)
    fun deleteStockFromFavorite(name: String)
}