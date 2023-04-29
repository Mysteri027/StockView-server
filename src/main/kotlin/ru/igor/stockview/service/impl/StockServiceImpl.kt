package ru.igor.stockview.service.impl

import org.springframework.stereotype.Service
import ru.igor.stockview.dto.stock.AddStockRequestDto
import ru.igor.stockview.dto.stock.StockDto
import ru.igor.stockview.repository.StockRepository
import ru.igor.stockview.service.StockService
import yahoofinance.YahooFinance

@Service
class StockServiceImpl(
    private val stockRepository: StockRepository
) : StockService {
    override fun getAllStocks(): List<StockDto> {
        updateStocks()
        val stocks = stockRepository.findAll().map { it.toDto() }
        return stocks.ifEmpty { throw NoSuchElementException("Stock list are empty") }
    }

    override fun getStockByName(name: String): StockDto {
        val stock =
            stockRepository.findByName(name) ?: throw NoSuchElementException("Stock with name $name is not exist")
        return stock.toDto()
    }

    override fun getStockByTicker(ticker: String): StockDto {
        val stock = stockRepository.findByTicker(ticker)
            ?: throw NoSuchElementException("Stock with ticker $ticker is not exist")

        return stock.toDto()
    }

    override fun addStock(addStockRequestDto: AddStockRequestDto) {
        stockRepository.save(addStockRequestDto.toStockEntity())
    }

    override fun deleteAllStocks() {
        stockRepository.deleteAll()
    }

    override fun updateStocks() {
        val stocks = stockRepository.findAll()

        stocks.forEach {
            val yahooFinance = YahooFinance.get(it.ticker.uppercase())

            it.price = yahooFinance.quote.price.toDouble()
            it.change = yahooFinance.quote.change.toDouble()
            it.changeInPercent = yahooFinance.quote.changeInPercent.toDouble()

            stockRepository.save(it)

        }
    }

    override fun addStockToFavorite(name: String) {
        val stock =
            stockRepository.findByName(name) ?: throw NoSuchElementException("Stock with name $name is not exist")
        stock.isFavorite = true
        stockRepository.save(stock)
    }

    override fun deleteStockFromFavorite(name: String) {
        val stock =
            stockRepository.findByName(name) ?: throw NoSuchElementException("Stock with name $name is not exist")
        stock.isFavorite = false
        stockRepository.save(stock)
    }
}