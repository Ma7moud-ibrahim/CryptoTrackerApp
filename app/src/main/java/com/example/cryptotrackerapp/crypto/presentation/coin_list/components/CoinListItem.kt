package com.example.cryptotrackerapp.crypto.presentation.coin_list.components

import android.graphics.Color
import android.provider.CalendarContract
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cryptotrackerapp.crypto.domain.Coin
import com.example.cryptotrackerapp.crypto.presentation.models.CoinUi
import com.example.cryptotrackerapp.crypto.presentation.models.toCoinUi
import com.example.cryptotrackerapp.crypto.presentation.models.toDisplayableNumber
import com.plcoding.cryptotracker.ui.theme.CryptoTrackerTheme

@Composable
fun CoinListItem(
    coinUi: CoinUi,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val contentColor = if (isSystemInDarkTheme()) {
        androidx.compose.ui.graphics.Color.White
    } else {
        androidx.compose.ui.graphics.Color.Black
    }
    Row (
        modifier = modifier
            .clickable(onClick = onClick)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        Icon(
            imageVector = ImageVector.vectorResource(id = coinUi.iconRes),
            contentDescription = coinUi.name,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(85.dp)
        )
        Column (
            modifier = Modifier.weight(1f),
        ) {
            Text(
                text = coinUi.symbol,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = contentColor,
            )
            Text(
                text = coinUi.name,
                fontSize = 14.sp,
                fontWeight = FontWeight.Light,
                color = contentColor,

            )

        }
        Column (
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "$ ${coinUi.marketCapUsd.formatted}",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = contentColor,

                )
            PriceChange(
                change = coinUi.changePercent24Hr,
            )
        }
    }

}

@Preview
@Composable
@PreviewLightDark
fun CoinListItemPreview() {
    CryptoTrackerTheme {
        CoinListItem(
            coinUi = previewCoinUi,
            modifier = Modifier.background(MaterialTheme.colorScheme.primaryContainer)
        ) {
            
        }
    }
}

internal val previewCoinUi = Coin(
    id = "1",
    rank = 1,
    name = "Bitcoin",
    symbol = "BTC",
    marketCapUsd = 10000.0,
    priceUsd = 10000.0,
    changePercent24Hr = -100.0,
).toCoinUi()
