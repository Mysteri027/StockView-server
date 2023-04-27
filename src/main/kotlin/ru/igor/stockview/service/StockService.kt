package ru.igor.stockview.service

import org.springframework.stereotype.Service
import ru.igor.stockview.dto.StockDto

@Service
interface StockService {
    fun getAllStocks(): List<StockDto>
    fun getStockByName(name: String) : StockDto
    fun addStock(stockDto: StockDto)
    fun deleteAllStocks()
    fun updateStock(stock: StockDto)
}