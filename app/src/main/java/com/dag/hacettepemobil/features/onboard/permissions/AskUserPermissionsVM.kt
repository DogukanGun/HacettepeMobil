package com.dag.hacettepemobil.features.onboard.permissions

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import com.dag.hacettepemobil.R
import com.dag.hacettepemobil.base.HacettepeMobilVM
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AskUserPermissionsVM @Inject constructor():HacettepeMobilVM() {

    private val notificationState = AskUserPermissionVS.NotificationPermission(
        R.string.permission_text_1,R.drawable.ic_permission_1
    )

    private val locationState = AskUserPermissionVS.LocationPermission(
        R.string.permission_text_2,R.drawable.ic_permission_2
    )

    var askUserPermissionVs by mutableStateOf<AskUserPermissionVS>(notificationState)
    var buttonText by mutableStateOf(R.string.permission_text_1)
    var image by mutableStateOf(R.drawable.ic_permission_1)
    var permissionIndex by mutableStateOf(0)


    fun askNotificationPermission(){
        buttonText = notificationState.text
        image = notificationState.image
    }

    fun askLocationPermission(){
        buttonText = locationState.text
        image = locationState.image
        permissionIndex += 1
    }

    fun changeState(){
        when(askUserPermissionVs){
            is AskUserPermissionVS.NotificationPermission ->{
                askUserPermissionVs = locationState
            }
            is AskUserPermissionVS.LocationPermission ->{
                askUserPermissionVs = AskUserPermissionVS.PermissionDone
            }
            AskUserPermissionVS.PermissionDone ->{}
        }
    }

}