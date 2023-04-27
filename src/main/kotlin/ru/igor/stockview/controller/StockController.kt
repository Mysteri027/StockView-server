package ru.igor.stockview.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.igor.stockview.dto.stock.AddStockRequestDto
import ru.igor.stockview.dto.stock.StockDto
import ru.igor.stockview.service.StockService


@RestController
@RequestMapping("/api/v1/stock")
class StockController(private val stockService: StockService) {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFoundException(e: NoSuchElementException): ResponseEntity<Map<String, String?>> {
        return ResponseEntity(mapOf("message" to e.message), HttpStatus.NOT_FOUND)
    }

    @GetMapping("")
    fun getAllStocks(): List<StockDto> {
        return stockService.getAllStocks()
    }

    @GetMapping("/name/{name}")
    fun getStockByName(@PathVariable("name") name: String): StockDto {
        return stockService.getStockByName(name)
    }

    @GetMapping("/ticker/{ticker}")
    fun getStockByTicker(@PathVariable("ticker") ticker: String): StockDto {
        return stockService.getStockByTicker(ticker.uppercase())
    }

    @PostMapping("/add")
    fun addStock(@RequestBody addStockRequestDto: AddStockRequestDto) {
        stockService.addStock(addStockRequestDto)
    }

    @DeleteMapping("/delete")
    fun deleteAllStocks() {
        stockService.deleteAllStocks()
    }
}