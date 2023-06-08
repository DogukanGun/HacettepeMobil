package com.dag.hacettepemobil.features.onboard.permissions

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dag.hacettepemobil.R
import com.dag.hacettepemobil.component.HacettepeSurface
import com.dag.hacettepemobil.component.hacettepebutton.HacettepeButton
import com.dag.hacettepemobil.ui.theme.HacettepeMobilTheme

@Composable
fun UserPermissionOnboard(){
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_permission_1),
                contentDescription = "Halloo"
            )
            Spacer(modifier = Modifier.height(100.dp))
            HacettepeButton(
                modifier = Modifier.padding(vertical = 10.dp),
                buttonText = R.string.permission_text_1,
                onClick = {}
            )
        }
    }
}


@Preview
@Composable
fun UserPermissionOnboardPreview(){
    HacettepeMobilTheme {
        UserPermissionOnboard()
    }
}