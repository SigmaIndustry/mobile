package com.example.sigmaindastri.controller

import com.example.sigmaindastri.model.Constants
import com.example.sigmaindastri.model.LoginRequest
import com.example.sigmaindastri.model.LoginResponse
import com.example.sigmaindastri.model.SearchRequest
import com.example.sigmaindastri.model.SearchResponse
import com.example.sigmaindastri.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST(Constants.LOGIN_URL)
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @POST(Constants.REGISTRATION_URL)
    fun signUp(@Body request: User): Call<LoginResponse>

    @POST(Constants.SEARCH_URL)
    fun search(@Body request: SearchRequest): Call<SearchResponse>

}