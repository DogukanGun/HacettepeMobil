package com.dag.hacettepemobil.base.ext

import com.dag.hacettepemobil.base.HacettepeMobilVS
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.suspendCancellableCoroutine

interface RepeatableRentViewEffect : HacettepeMobilVS {

    var onRepeatAction: ((Boolean) -> Unit)?
}

@OptIn(ExperimentalCoroutinesApi::class)
suspend fun HacettepeMobilVS.shouldRetry(): Boolean = suspendCancellableCoroutine { continuation ->
    if (this is RepeatableRentViewEffect) {
        onRepeatAction = {
            continuation.resume(it,null)
        }
    } else {
        continuation.resume(false,null)
    }
}