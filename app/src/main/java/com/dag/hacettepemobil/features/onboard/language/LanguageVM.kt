package com.dag.hacettepemobil.features.onboard.language

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.dag.hacettepemobil.base.HacettepeMobilVM
import com.dag.hacettepemobil.data.LanguageModel
import javax.inject.Inject

class LanguageVM @Inject constructor(): HacettepeMobilVM() {
    var selectedLanguage by mutableStateOf<LanguageModel?>(null)
    var languageVS by mutableStateOf<LanguageVS?>(null)

    fun isButtonActive():Boolean{
        return selectedLanguage != null
    }

    fun saveLanguage(){
        languageVS = LanguageVS.GoToLoginPage
    }
}