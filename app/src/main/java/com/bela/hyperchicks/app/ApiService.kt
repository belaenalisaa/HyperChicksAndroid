package com.bela.hyperchicks.app


import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.POST

interface ApiService {

    @POST("registrasi")
    fun registrasi(
        @Field("name") name :String,
        @Field("email") email :String,
        @Field("password") password :String
    ): Call<ResponseBody>

    @POST("login")
    fun login(
        @Field("name") name :String,
        @Field("email") email :String,
        @Field("password") password :String
    ): Call<ResponseBody>
}