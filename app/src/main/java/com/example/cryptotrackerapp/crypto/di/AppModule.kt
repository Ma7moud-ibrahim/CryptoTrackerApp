package com.example.cryptotrackerapp.crypto.di

import com.example.cryptotrackerapp.core.data.networking.HttpClientFactory
import com.example.cryptotrackerapp.crypto.domain.CoinDataSource
import io.ktor.client.engine.cio.CIO
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import com.example.cryptotrackerapp.crypto.data.networking.RemoteCoinDataSource
import com.example.cryptotrackerapp.crypto.presentation.coin_list.CoinListViewModel
import org.koin.dsl.bind
import org.koin.dsl.module


val appModule = module {

    single { HttpClientFactory.create(CIO.create()) } // Create a single instance of HttpClientFactory
    singleOf(::RemoteCoinDataSource).bind<CoinDataSource>() // Bind RemoteCoinDataSource to CoinDataSource

    viewModelOf(::CoinListViewModel)// Create a ViewModel instance
}
