package ru.igor.stockview.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import ru.igor.stockview.dto.stock.StockDto

@Entity
@Table(name = "stock")
class StockEntity(
    @Id
    @Column(name = "name")
    val name: String = "",

    @Column(name = "ticker")
    val ticker: String = "",

    @Column(name = "company_description")
    val companyDescription: String = "",

    @Column(name = "price")
    var price: Double = 0.0,

    @Column(name = "change")
    var change: Double = 0.0,

    @Column(name = "changeInPercent")
    var changeInPercent: Double = 0.0,

    @Column(name = "image_url")
    val imageUrl: String = "",

    @Column(name = "will_price_go_up")
    val willPriceGoUp: Boolean = false
) {
    fun toDto(): StockDto {
        return StockDto(
            name = this.name,
            ticker = this.ticker.uppercase(),
            companyDescription = this.companyDescription,
            price = this.price,
            change = this.change,
            changeInPercent = this.changeInPercent,
            imageUrl = this.imageUrl,
            willPriceGoUp = this.willPriceGoUp
        )
    }
}