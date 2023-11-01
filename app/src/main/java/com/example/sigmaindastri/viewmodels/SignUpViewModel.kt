package com.example.sigmaindastri.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sigmaindastri.controller.ApiClient
import com.example.sigmaindastri.controller.SessionManager
import com.example.sigmaindastri.model.LoginRequest
import com.example.sigmaindastri.model.SignupRequest
import kotlinx.coroutines.launch

class SignUpViewModel(): ViewModel() {
    val apiClient = ApiClient()
    var token = "null"
    fun signUpRequest(        email: String,
                              password: String,
                              firstName: String,
                              lastName: String,
                              birthDate: String,
                              sex: String,
                              photoUrl: String,
                              role: String,
                              sessionManager: SessionManager
    ) {
        val apiService = apiClient.getApiService()
        viewModelScope.launch {
            try {
                token = apiService.signUp(SignupRequest(
                    email,
                    password,
                    firstName,
                    lastName,
                    birthDate,
                    sex,
                    photoUrl,
                    role
                )).token
            }
            catch (e: Exception) {
                println( e.message.toString())
            }
        }
    }
}