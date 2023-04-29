package ru.igor.stockview.dto.stock

import ru.igor.stockview.entity.StockEntity
import yahoofinance.YahooFinance

data class AddStockRequestDto(
    val name: String,
    val ticker: String,
    val imageUrl: String,
    val companyDescription: String,
    val willPriceGoUp: Boolean,
) {
    fun toStockEntity(): StockEntity {
        val stock = YahooFinance.get(this.ticker.uppercase())

        return StockEntity(
            name = this.name,
            ticker = this.ticker,
            companyDescription = this.companyDescription,
            price = stock.quote.price.toDouble(),
            change = stock.quote.change.toDouble(),
            changeInPercent = stock.quote.changeInPercent.toDouble(),
            imageUrl = this.imageUrl,
            willPriceGoUp = this.willPriceGoUp,
            isFavorite = false,
        )
    }
}
