package ru.igor.stockview.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.igor.stockview.dto.StockDto
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

    @GetMapping("{name}")
    fun getStockByName(@PathVariable("name") name: String): StockDto {
        return stockService.getStockByName(name)
    }

    @PostMapping("/add")
    fun addStock(@RequestBody stockDto: StockDto) {
        stockService.addStock(stockDto)
    }

    @DeleteMapping("/delete")
    fun deleteAllStocks() {
        stockService.deleteAllStocks()
    }

    @PostMapping("/update")
    fun updateStock(@RequestBody stockDto: StockDto) {
        stockService.updateStock(stockDto)
    }
}