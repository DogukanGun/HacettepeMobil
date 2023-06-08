package com.dag.hacettepemobil.base.network

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class ApiResponse<T>(

    val data:T?,
    val error:Boolean?
){
    val isFailure get() = error == true
}

@Parcelize
data class ClError(
    val message:String,
    val success:Boolean
):Parcelable

fun <T> BaseResult<ApiResponse<T>>.getDataAsResult(): BaseResult<T> {
    return when(this){
        is BaseResult.Success ->{
            val response = data ?: return BaseResult.Success(null)
            when{
                response.isFailure.not() -> BaseResult.Success(response.data)
                else -> BaseResult.Error(NetworkConnectionFailure)
            }
        }
        is BaseResult.Loading -> BaseResult.Loading
        is BaseResult.Error -> BaseResult.Error(exception)
    }
}