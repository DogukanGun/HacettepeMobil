package com.dag.hacettepemobil.features.onboard.permissions

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dag.hacettepemobil.R
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.dag.hacettepemobil.component.hacettepebutton.HacettepeButton
import com.dag.hacettepemobil.navigation.NavScreen
import com.dag.hacettepemobil.ui.theme.HacettepeMobilTheme

@Composable
fun UserPermissionOnboard(
    viewModel: AskUserPermissionsVM = viewModel(),
    navController: NavHostController,
){
    val permissions = arrayOf(
        arrayOf(android.Manifest.permission.ACCESS_NOTIFICATION_POLICY),
        arrayOf(
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
        )
    )
    val requestPermissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { isGranted ->
        val resultOfPermission = isGranted.values.reduce{ res,item-> res && item  }
        if (resultOfPermission) {
            viewModel.changeState()
        }
    }
    LaunchedEffect(key1 = viewModel.askUserPermissionVs){
        when(viewModel.askUserPermissionVs){
            is AskUserPermissionVS.NotificationPermission ->{
                viewModel.askNotificationPermission()
            }
            is AskUserPermissionVS.LocationPermission ->{
                viewModel.askLocationPermission()
            }
            AskUserPermissionVS.PermissionDone ->{
                navController.navigate(NavScreen.LanguageSelection.route)
            }
        }
    }

    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = viewModel.image),
                contentDescription = "Halloo"
            )
            Spacer(modifier = Modifier.height(100.dp))
            HacettepeButton(
                modifier = Modifier.padding(vertical = 10.dp),
                buttonText = viewModel.buttonText,
                onClick = {
                    requestPermissionLauncher.launch(permissions[viewModel.permissionIndex])
                }
            )
            TextButton(onClick = { viewModel.changeState() }) {
                Text(text = stringResource(id = R.string.permission_skip))
            }
        }
    }
}


@Preview
@Composable
fun UserPermissionOnboardPreview(){
    HacettepeMobilTheme {
        UserPermissionOnboard(
            navController =  rememberNavController(),
            )
    }
}