package ru.mezhendosina.itmo.enterance.data.requests

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface QrApi {

    @POST("pls/apex/wwv_flow.show")
    @FormUrlEncoded
    suspend fun getQr(
        @Header("Cookie") cookie: String,
        @Field("p_flow_id") flowId: Int = 2437,
        @Field("p_flow_step_id") flowStepId: Int = 121,
        @Field("p_instance") instance: Long = 110914838795764,
        @Field("p_request") request: String = "APPLICATION_PROCESS=GET_HEXCODE"
    ): QrResponseRequest
}