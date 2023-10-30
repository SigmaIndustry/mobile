package com.example.sigmaindastri.controller

import com.example.sigmaindastri.model.LoginRequest
import com.example.sigmaindastri.model.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginController(val sessionManager: SessionManager) {
    var apiClient = ApiClient()
    fun loginRequest(email:String, password:String){
        apiClient.getApiService()
            .login(LoginRequest(email = email, password = password))
            .enqueue(object : Callback<LoginResponse> {
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    // Error logging in
                }

                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    val loginResponse = response.body()

                    if (loginResponse?.statusCode == 200) {
                        sessionManager.saveAuthToken(loginResponse.token)
                    } else {
                        // Error logging in
                    }
                }
            })
    }
}