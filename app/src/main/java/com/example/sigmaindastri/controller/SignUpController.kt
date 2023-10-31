package com.example.sigmaindastri.controller

import com.example.sigmaindastri.model.LoginRequest
import com.example.sigmaindastri.model.LoginResponse
import com.example.sigmaindastri.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpController(val sessionManager: SessionManager) {
    var apiClient = ApiClient()
    fun signUpRequest(
        email: String,
        password: String,
        firstName: String,
        lastName: String,
        birthDate: String,
        sex: String,
        photoUrl: String,
        role: String
    ) {
        apiClient.getApiService()
            .signUp(
                User(email, password, firstName, lastName, birthDate, sex, photoUrl, role))
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