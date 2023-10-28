package com.example.sigmaindastri

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @POST(Constants.LOGIN_URL)
    @FormUrlEncoded
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @POST(Constants.REGISTRATION_URL)
    @FormUrlEncoded
    fun register(@Body request: User): Call<LoginResponse>

}