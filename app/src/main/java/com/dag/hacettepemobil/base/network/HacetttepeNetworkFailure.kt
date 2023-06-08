package com.dag.hacettepemobil.base.network

import java.io.IOException

sealed class HacetttepeNetworkFailure : IOException()

object NetworkConnectionFailure : HacetttepeNetworkFailure()

object UnauthenticatedFailure : HacetttepeNetworkFailure()

object SocketTimeoutFailure : HacetttepeNetworkFailure()

