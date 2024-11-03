package com.example.cryptotrackerapp.crypto.domain

import com.example.cryptotrackerapp.core.domain.util.NetworkError
import com.example.cryptotrackerapp.core.domain.util.Result

interface CoinDataSource {
    suspend fun getCoins(): Result<List<Coin>,NetworkError>


}