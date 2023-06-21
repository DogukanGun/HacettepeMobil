package com.dag.hacettepemobil.features.onboard.resetpassword

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import com.dag.hacettepemobil.navigation.NavScreen
import com.dag.hacettepemobil.ui.theme.HacettepeMobilTheme

@Composable
fun ResetPassword(
    navController:NavController
){
    val email = remember { mutableStateOf("") }

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
                painter = painterResource(R.drawable.ic_permission_2),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(fraction = 0.5f)
                    .fillMaxHeight(fraction = 0.4f)
                    .padding(top = 32.dp),
                contentScale = ContentScale.Fit
            )
            Text(
                text = stringResource(id = R.string.reset_password_step1_title),
                color = Color.Gray,
                fontSize = 16.sp,
                fontFamily = FontFamily.Default,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                textAlign = TextAlign.Center,
            )
            HacettepeField(
                value = email,
                labelId = R.string.reset_password_step1_email,
                onValueChange = {
                    email.value = it
                },
                modifier = Modifier
                    .background(Color.White)
            )
        }
        HacettepeButton(
            modifier = Modifier
                .padding(bottom = 32.dp),
            buttonText = R.string.login_button_secondary,
            onClick = {
                navController.navigate(NavScreen.Register.route)
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