package com.example.sigmaindastri.controller

import com.example.sigmaindastri.model.Constants
import com.example.sigmaindastri.model.LoginRequest
import com.example.sigmaindastri.model.LoginResponse
import com.example.sigmaindastri.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST(Constants.LOGIN_URL)
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @POST(Constants.REGISTRATION_URL)
    fun register(@Body request: User): Call<LoginResponse>

}