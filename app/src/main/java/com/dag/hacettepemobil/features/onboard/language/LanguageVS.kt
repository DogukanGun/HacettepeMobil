package com.dag.hacettepemobil.features.onboard.language

import com.dag.hacettepemobil.base.HacettepeMobilVS

sealed class LanguageVS: HacettepeMobilVS{
    object GoToLoginPage: LanguageVS()
}
