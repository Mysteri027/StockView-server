package ru.igor.stockview

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StockViewApplication

fun main(args: Array<String>) {
	runApplication<StockViewApplication>(*args)
}
