package com.example.cryptotrackerapp.crypto.presentation.coin_list

import com.example.cryptotrackerapp.core.domain.util.NetworkError

sealed interface CoinListEvent {
    data class Error(val error: NetworkError):CoinListEvent
}