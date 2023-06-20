package com.dag.hacettepemobil.base.settings

import com.dag.hacettepemobil.R
import com.dag.hacettepemobil.data.LanguageModel
import com.dag.hacettepemobil.data.Languages
import javax.inject.Inject


class SettingsService @Inject constructor() {

    fun getLanguages():List<LanguageModel> = listOf(
        LanguageModel(Languages.England.name,Languages.England.countryCode, R.drawable.ic_permission_2),
        LanguageModel(Languages.Turkey.name,Languages.Turkey.countryCode, R.drawable.ic_permission_2),
        LanguageModel(Languages.Arabic.name,Languages.Arabic.countryCode, R.drawable.ic_permission_2)
    )
}