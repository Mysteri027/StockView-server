package ru.igor.stockview.dto

import ru.igor.stockview.entity.StockEntity

data class StockDto(
    val name: String,
    val companyDescription: String,
    val price: Double,
    val change: Double,
    val changeInPercent: Double,
    val imageUrl: String,
    val willPriceGoUp: Boolean,
) {
    fun toEntity(): StockEntity {
        return StockEntity(
            name = this.name,
            companyDescription = this.companyDescription,
            price = this.price,
            change = this.change,
            changeInPercent = this.changeInPercent,
            imageUrl = this.imageUrl,
            willPriceGoUp = this.willPriceGoUp
        )
    }
}
