package com.example.neco1

enum class Rarity {
    COMMON, RARE, EPIC, LEGENDARY, SPECIAL
}

data class Car(
    var manufacturer: String,
    var model: String,
    var year: Int? = null,
    var rarity: Rarity = Rarity.COMMON,
    var isPremium: Boolean = false,
    var colors: List<Long> = listOf(),
    )
