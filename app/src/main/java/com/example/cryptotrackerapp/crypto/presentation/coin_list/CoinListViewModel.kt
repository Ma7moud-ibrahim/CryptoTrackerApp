package com.example.cryptotrackerapp.crypto.presentation.coin_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptotrackerapp.core.domain.util.onError
import com.example.cryptotrackerapp.core.domain.util.onSuccess
import com.example.cryptotrackerapp.crypto.domain.CoinDataSource
import com.example.cryptotrackerapp.crypto.presentation.models.toCoinUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CoinListViewModel(
    private val coinDataSource: CoinDataSource
) : ViewModel() {

    private val _state = MutableStateFlow(CoinListState()) // Mutable state flow
    val state = _state.
        onStart { loadState() }// Start loading state
        .stateIn( // Convert to state flow
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),// Stop loading after 5 seconds
            CoinListState()
        )
    fun onAction(action : CoinListAction) {
     when (action) {
         is CoinListAction.OnCoinClick -> {

         }
//         CoinListAction.onRefresh ->{
//             loadState()
//         }
     }
    }

    private fun loadState() { // Load state from data source
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }

            coinDataSource
                .getCoins()
                .onSuccess { coins -> // Handle success
                    _state.update {
                        it.copy(
                            isLoading = false,
                            coins = coins.map { it.toCoinUi() }
                        )
                    }
                }
                .onError { error -> // Handle error
                    _state.update {
                        it.copy(
                            isLoading = false,
                        )
                    }

                }
        }
    }
}