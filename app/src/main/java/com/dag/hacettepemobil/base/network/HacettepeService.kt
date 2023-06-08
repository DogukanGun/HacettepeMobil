package com.dag.hacettepemobil.base.network

import com.dag.hacettepemobil.base.network.BaseResult
import retrofit2.http.*

interface HacettepeService {
    @POST
    fun genericPostRequest(@Url url: String?, @Body body:Any? = {}): BaseResult<*>

    @GET
    fun genericGetRequest(@Url url: String?): BaseResult<*>

    @PUT
    fun genericPutRequest(@Url url: String?, @Body body:Any? = {}): BaseResult<*>

    @DELETE
    fun genericDeleteRequest(@Url url: String?): BaseResult<*>

}