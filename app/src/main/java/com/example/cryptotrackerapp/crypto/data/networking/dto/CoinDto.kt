@file:Suppress("PLUGIN_IS_NOT_ENABLED")

package com.example.cryptotrackerapp.crypto.data.networking.dto

import kotlinx.serialization.Serializable

@Serializable // To serialize this class to JSON
data class CoinDto(
    val id: String,
    val rank: Int,
    val name: String,
    val symbol: String,
    val marketCapUsd: Double,
    val priceUsd: Double,
    val changePercent24Hr: Double

)
