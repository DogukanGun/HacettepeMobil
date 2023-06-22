package com.dag.hacettepemobil.features.onboard.resetpassword

import com.dag.hacettepemobil.base.HacettepeMobilVS

sealed class ResetPasswordVS: HacettepeMobilVS {
    object GetEmail: ResetPasswordVS()
    object GetVerificationCode: ResetPasswordVS()
    object NewPassword: ResetPasswordVS()
    object PasswordChanged: ResetPasswordVS()
}