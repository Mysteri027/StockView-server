package ru.igor.stockview.service.impl

import org.springframework.stereotype.Service
import ru.igor.stockview.dto.StockDto
import ru.igor.stockview.repository.StockRepository
import ru.igor.stockview.service.StockService

@Service
class StockServiceImpl(
    private val stockRepository: StockRepository
) : StockService {
    override fun getAllStocks(): List<StockDto> {
        val stocks = stockRepository.findAll().map { it.toDto() }
        return stocks.ifEmpty { throw NoSuchElementException("Stock list are empty") }
    }

    override fun getStockByName(name: String): StockDto {
        val stock =
            stockRepository.findByName(name) ?: throw NoSuchElementException("Stock with name $name is not exist")
        return stock.toDto()
    }

    override fun addStock(stockDto: StockDto) {
        stockRepository.save(stockDto.toEntity())
    }

    override fun deleteAllStocks() {
        stockRepository.deleteAll()
    }

    override fun updateStock(stock: StockDto) {
        stockRepository.delete(stock.toEntity())
        stockRepository.save(stock.toEntity())
    }
}