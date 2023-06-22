package com.dag.hacettepemobil.features.onboard.resetpassword

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dag.hacettepemobil.R
import com.dag.hacettepemobil.component.hacettepebutton.HacettepeButton
import com.dag.hacettepemobil.component.hacettepefield.HacettepeField
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dag.hacettepemobil.navigation.NavScreen
import com.dag.hacettepemobil.ui.theme.HacettepeMobilTheme

@Composable
fun ResetPassword(
    navController:NavController,
    viewModel:ResetPasswordVM = viewModel()
){
    val firstTextField = remember { mutableStateOf("") }
    val secondTextField = remember { mutableStateOf("") }
    LaunchedEffect(key1 = viewModel.screenState){
        if (viewModel.screenState == ResetPasswordVS.PasswordChanged){
            navController.navigate(NavScreen.Login.route)
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 32.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(viewModel.imageResId),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.5f)
                    .fillMaxHeight(fraction = 0.4f)
                    .padding(top = 32.dp),
                contentScale = ContentScale.Fit
            )
            Text(
                text = stringResource(id = viewModel.imageTextResId),
                color = Color.Gray,
                fontSize = 16.sp,
                fontFamily = FontFamily.Default,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                textAlign = TextAlign.Center,
            )
            HacettepeField(
                value = firstTextField,
                labelId = viewModel.firstTextFieldData.textId,
                placeholder = viewModel.firstTextFieldData.placeholder,                onValueChange = {
                    firstTextField.value = it
                },
                modifier = Modifier
                    .background(Color.White)
            )
            if (viewModel.secondFieldVisibility){
                HacettepeField(
                    value = secondTextField,
                    labelId = viewModel.secondTextFieldData.textId,
                    placeholder = viewModel.secondTextFieldData.placeholder,
                    onValueChange = {
                        secondTextField.value = it
                    },
                    modifier = Modifier
                        .background(Color.White)
                )
            }
            if (viewModel.sendCodeAgainVisibility){
                TextButton(
                    onClick = {},
                    modifier = Modifier
                        .padding(top = 16.dp)
                ){
                    Text(
                        text = "Yeniden Kod Gönder >",
                        style = MaterialTheme.typography.h3
                    )
                }
                Text(
                    text = "Gönderilen kod  5 dakika boyunca geçerlidir.",
                    style = MaterialTheme.typography.body2
                )
            }
        }
        HacettepeButton(
            modifier = Modifier
                .padding(bottom = 32.dp),
            buttonText = viewModel.buttonTextId,
            onClick = {
                viewModel.changeState()
            }
        )
    }
}

@Composable
@Preview
fun ResetPasswordPreview(){
    HacettepeMobilTheme {
        ResetPassword(
            navController = rememberNavController()
        )
    }
}