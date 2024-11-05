package com.example.cryptotrackerapp.core.presentation.util

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

@Composable
fun <T>ObserveAsEvents(
    event : Flow<T>,
    Key1: Any? = null,
    Key2: Any? = null,
    onEvent: (T) -> Unit,
) {
    val context = LocalContext.current // Get the context
    val lifecycleOwner = LocalLifecycleOwner.current // Get the lifecycle owner

    LaunchedEffect(lifecycleOwner.lifecycle, Key1, Key2) { // Launched effect to collect events
        withContext(Dispatchers.Main.immediate){ // Switch to main dispatcher
            lifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) { // Repeat on started state
                event.collect(onEvent) // Collect events)
            }
        }
    }
}