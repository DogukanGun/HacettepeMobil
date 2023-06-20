package com.dag.hacettepemobil.features.onboard.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dag.hacettepemobil.R
import com.dag.hacettepemobil.base.settings.SettingsService
import com.dag.hacettepemobil.component.hacettepebutton.HacettepeButton
import com.dag.hacettepemobil.component.hacettepecarousel.HacettepeCarousel
import com.dag.hacettepemobil.component.hacettepefield.HacettepeField
import com.dag.hacettepemobil.ui.theme.HacettepeMobilTheme

@Composable
fun Login(
    settingsService: SettingsService
) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(30.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HacettepeCarousel(
            items = settingsService.getCarouselItems(),
            modifier = Modifier
                .fillMaxWidth(fraction = 1f)
                .fillMaxHeight(fraction = 0.4f),
        )
        HacettepeField(
            value = email,
            labelId = R.string.login_email,
            onValueChange = {
                email.value = it
            },
            modifier = Modifier
                .background(Color.White)
        )
        HacettepeField(
            value = password,
            labelId = R.string.login_password,
            onValueChange = {
                password.value = it
            },
            modifier = Modifier
                .background(Color.White)
        )
        HacettepeButton(
            modifier = Modifier,
            buttonText = R.string.login_button_primary,
            isPrimary = true,
            onClick = {}
        )
        HacettepeButton(
            modifier = Modifier,
            buttonText = R.string.login_button_secondary,
            isPrimary = false,
            onClick = {}
        )

    }
}

@Preview
@Composable
fun LoginPreview(){
    HacettepeMobilTheme{
        Login(
            settingsService = SettingsService()
        )
    }
}