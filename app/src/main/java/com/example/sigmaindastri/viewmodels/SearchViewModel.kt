package com.example.sigmaindastri.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sigmaindastri.controller.ApiClient
import com.example.sigmaindastri.controller.ApiService
import com.example.sigmaindastri.controller.SearchController
import com.example.sigmaindastri.controller.SessionManager
import com.example.sigmaindastri.model.SearchRequest
import com.example.sigmaindastri.model.SearchResponse
import com.example.sigmaindastri.model.SearchResult
import kotlinx.coroutines.launch

class MainViewModel(val sessionManager: SessionManager) : ViewModel() {
    var searchResultsResponse:List<SearchResult> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")
    val apiClient = ApiClient()
    fun getProductList() {
        val apiService = apiClient.getApiService()
        viewModelScope.launch {
            try {
                val response:SearchResponse
                searchResultsResponse
            }
            catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}