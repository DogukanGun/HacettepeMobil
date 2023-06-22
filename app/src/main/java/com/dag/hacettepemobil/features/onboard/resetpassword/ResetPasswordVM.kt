package com.dag.hacettepemobil.features.onboard.resetpassword

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.dag.hacettepemobil.R
import com.dag.hacettepemobil.base.HacettepeMobilVM
import com.dag.hacettepemobil.component.hacettepefield.HacettepeFieldModel
import javax.inject.Inject

class ResetPasswordVM @Inject constructor(): HacettepeMobilVM(){
    var screenState by mutableStateOf<ResetPasswordVS>(ResetPasswordVS.GetEmail)
    var buttonTextId by mutableStateOf(R.string.login_button_secondary)
    var imageResId by mutableStateOf(R.drawable.ic_permission_2)
    var imageTextResId by mutableStateOf(R.string.app_name)
    var secondFieldVisibility by mutableStateOf(false)
    var sendCodeAgainVisibility by mutableStateOf(false)
    val firstTextFieldData by mutableStateOf(HacettepeFieldModel(R.string.reset_password,""))
    val secondTextFieldData by mutableStateOf(HacettepeFieldModel(R.string.reset_password,""))

    fun changeState(){
        when(screenState){
            ResetPasswordVS.GetEmail ->{
                changeScreenForGetVerificationCode()
                screenState = ResetPasswordVS.GetVerificationCode
            }
            ResetPasswordVS.GetVerificationCode ->{
                changeScreenForNewPassword()
                screenState = ResetPasswordVS.NewPassword
            }
            ResetPasswordVS.NewPassword ->{
                screenState = ResetPasswordVS.PasswordChanged
            }
            ResetPasswordVS.PasswordChanged ->{}
        }
    }

    private fun changeScreenForNewPassword(){
        secondFieldVisibility = true
        sendCodeAgainVisibility = false
    }

    private fun changeScreenForGetVerificationCode(){
        sendCodeAgainVisibility = true
    }

}