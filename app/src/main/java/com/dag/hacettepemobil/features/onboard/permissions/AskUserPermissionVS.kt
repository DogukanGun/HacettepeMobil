package com.dag.hacettepemobil.features.onboard.permissions

import com.dag.hacettepemobil.base.HacettepeMobilVS

sealed class AskUserPermissionVS: HacettepeMobilVS {
    class NotificationPermission(val text:Int,val image:Int): AskUserPermissionVS()
    class LocationPermission(val text:Int, val image:Int): AskUserPermissionVS()
    object PermissionDone: AskUserPermissionVS()
}