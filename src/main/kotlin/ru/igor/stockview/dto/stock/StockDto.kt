package ru.igor.stockview.dto.stock

import ru.igor.stockview.entity.StockEntity
import java.util.*

data class StockDto(
    val name: String,
    val ticker: String,
    val companyDescription: String,
    val price: Double,
    val change: Double,
    val changeInPercent: Double,
    val imageUrl: String,
    val willPriceGoUp: Boolean,
    val isFavorite: Boolean,
) {
    fun toEntity(): StockEntity {
        return StockEntity(
            name = this.name,
            ticker = this.ticker.uppercase(Locale.getDefault()),
            companyDescription = this.companyDescription,
            price = this.price,
            change = this.change,
            changeInPercent = this.changeInPercent,
            imageUrl = this.imageUrl,
            willPriceGoUp = this.willPriceGoUp,
            isFavorite = this.isFavorite
        )
    }
}
