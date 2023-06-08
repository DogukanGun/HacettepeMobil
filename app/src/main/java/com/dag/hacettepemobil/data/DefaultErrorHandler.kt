package com.dag.hacettepemobil.data


import com.dag.hacettepemobil.base.HacettepeMobilVS
import javax.inject.Inject

open class DefaultErrorHandler @Inject constructor() : ErrorHandler {

    override fun handle(throwable: Throwable): HacettepeMobilVS? {
        if (throwable !is HacettepeMobilVS) {
            return null
        }

        return null
        // TODO create generic error dialog
        /*return when (throwable) {
            NetworkConnectionFailure -> networkConnectionDialog()
            UnauthenticatedFailure -> networkConnectionDialog()
            SocketTimeoutFailure, is UnexpectedFailure -> createGenericDialog()
            else -> {null}
        }*/
    }
}
