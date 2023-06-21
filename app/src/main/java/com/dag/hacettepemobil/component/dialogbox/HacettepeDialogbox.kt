package com.dag.hacettepemobil.component.dialogbox

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.dag.hacettepemobil.R
import com.dag.hacettepemobil.component.hacettepebutton.HacettepeButton
import com.dag.hacettepemobil.navigation.NavScreen
import com.dag.hacettepemobil.ui.theme.HacettepeMobilTheme

@Composable
fun HacettepeDialogBox(
    onClick:()->Unit
){
    Column(
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .fillMaxHeight(0.4f)
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_permission_2),
            contentDescription = "Image"
        )
        Text(
            text = "Title",
        )
        Text(
            text = "Message"
        )
        HacettepeButton(
            modifier = Modifier,
            buttonText = R.string.login_button_secondary,
            isPrimary = false,
            onClick = onClick
        )
    }
}

@Composable
@Preview
fun HacettepeDialogBoxPreview(){
    HacettepeMobilTheme {
        HacettepeDialogBox(onClick = {})
    }
}