package com.example.cryptotrackerapp.crypto.presentation.coin_list

import com.example.cryptotrackerapp.crypto.presentation.models.CoinUi

sealed interface CoinListAction {// Actions for the coin list screen
    data class OnCoinClick(val coin: CoinUi) : CoinListAction
//    data object onRefresh : CoinListAction
}