package com.example.sigmaindastri.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sigmaindastri.controller.ApiClient
import com.example.sigmaindastri.controller.SessionManager
import com.example.sigmaindastri.model.LoginRequest
import kotlinx.coroutines.launch

class LoginViewModel(): ViewModel() {
    val apiClient = ApiClient()
    var token = "null"
    fun loginRequest(email:String, password:String, sessionManager: SessionManager) {
        val apiService = apiClient.getApiService()
        viewModelScope.launch {
            try {
                token = apiService.login(LoginRequest(email,password)).token
            }
            catch (e: Exception) {
                println( e.message.toString())
            }
        }
    }
}