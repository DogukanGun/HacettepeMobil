package com.dag.hacettepemobil.data

import com.dag.hacettepemobil.base.HacettepeMobilVS

interface ErrorHandler {

    fun handle(throwable: Throwable): HacettepeMobilVS?
}