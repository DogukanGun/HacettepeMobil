package com.dag.hacettepemobil.features.onboard.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dag.hacettepemobil.R
import com.dag.hacettepemobil.component.hacettepebutton.HacettepeButton
import com.dag.hacettepemobil.component.hacettepecheckbox.HacettepeCheckbox
import com.dag.hacettepemobil.component.hacettepefield.HacettepeField
import com.dag.hacettepemobil.ui.theme.HacettepeMobilTheme

@Composable
fun Register(){
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
        HacettepeField(
            value = email,
            labelId = R.string.register_name,
            onValueChange = {
                email.value = it
            },
            modifier = Modifier
                .background(Color.White)
        )
        HacettepeField(
            value = email,
            labelId = R.string.register_surname,
            onValueChange = {
                email.value = it
            },
            modifier = Modifier
                .background(Color.White)
        )
        HacettepeField(
            value = email,
            labelId = R.string.register_email,
            onValueChange = {
                email.value = it
            },
            modifier = Modifier
                .background(Color.White)
        )
        HacettepeField(
            value = email,
            labelId = R.string.register_password,
            onValueChange = {
                email.value = it
            },
            modifier = Modifier
                .background(Color.White)
        )
        HacettepeField(
            value = password,
            labelId = R.string.register_password_repeat,
            onValueChange = {
                password.value = it
            },
            modifier = Modifier
                .background(Color.White)
                .padding(bottom = 16.dp)
        )
        Checkmarks(
            text = R.string.app_name,
            onClick = {}
        )
        Checkmarks(
            text = R.string.app_name,
            onClick = {}
        )
        Checkmarks(
            text = R.string.app_name,
            onClick = {}
        )
        HacettepeButton(
            modifier = Modifier
                .padding(top = 16.dp),
            buttonText = R.string.login_button_primary,
            isPrimary = true,
            onClick = {}
        )
    }
}

@Composable
fun Checkmarks(
    text:Int,
    onClick:()->Unit
){
    var checkboxState by mutableStateOf(false)
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier.fillMaxWidth()
    ){
        HacettepeCheckbox(
            checked = checkboxState,
            onCheckedChange = {
                checkboxState = it
                onClick()
            }
        )
        Text(
            text = stringResource(id = text),
            modifier = Modifier
                .padding(start = 16.dp),
        )
    }
}

@Composable
@Preview
fun RegisterPreview(){
    HacettepeMobilTheme {
        Register()
    }
}