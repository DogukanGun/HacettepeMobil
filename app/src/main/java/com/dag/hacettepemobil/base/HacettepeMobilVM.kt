package com.dag.hacettepemobil.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.distinctUntilChanged
import androidx.lifecycle.viewModelScope
import com.dag.hacettepemobil.base.ext.onSuccess
import com.dag.hacettepemobil.base.ext.retryIf
import com.dag.hacettepemobil.base.ext.shouldRetry
import com.dag.hacettepemobil.base.network.BaseResult
import com.dag.hacettepemobil.data.DefaultErrorHandler
import com.dag.hacettepemobil.data.ErrorHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

abstract class HacettepeMobilVM : ViewModel() {
    var viewState = MutableLiveData<HacettepeMobilVS>()
    private val loading = MutableLiveData<Boolean>(false)

    protected fun <T> Flow<BaseResult<T>>.publishLoading() = onEach {
        updateLoading(it is BaseResult.Loading)
    }

    private fun updateLoading(isLoading: Boolean) {
        this.loading.value = isLoading
    }

    fun isLoading() = loading.distinctUntilChanged()

    protected fun postViewEffect(effect: HacettepeMobilVS) {
        viewState.value = effect
    }

    private fun <T> Flow<BaseResult<T>>.handleErrorWith(
        errorHandler: ErrorHandler?
    ): Flow<BaseResult<T>> = retryIf { exception, _ ->
        val effect = errorHandler?.handle(exception)
        effect?.let {
            postViewEffect(it)
            it.shouldRetry()
        } ?: false
    }

    protected fun <T> Flow<T>.subscribe() = launchIn(viewModelScope)

    protected fun <T> Flow<BaseResult<T>>.subscribe(
        errorHandler: ErrorHandler
    ) = handleErrorWith(errorHandler)
        .subscribe()

    protected fun <T> Flow<BaseResult<T>>.subscribe(
        errorHandler: ErrorHandler? = DefaultErrorHandler(),
        onSuccess: (T?) -> Unit
    ) = handleErrorWith(errorHandler)
        .onSuccess {
            onSuccess.invoke(it)
        }
        .subscribe()

    protected fun <T> Flow<BaseResult<T>>.subscribeNotNull(
        errorHandler: ErrorHandler = DefaultErrorHandler(),
        onSuccess: (T) -> Unit
    ) = subscribe(errorHandler) { result ->
        result?.let {
            onSuccess.invoke(it)
        }
    }
}