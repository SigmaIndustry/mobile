package com.example.sigmaindastri.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sigmaindastri.controller.ApiClient
import com.example.sigmaindastri.controller.ApiService
import com.example.sigmaindastri.controller.SessionManager
import com.example.sigmaindastri.model.SearchRequest
import com.example.sigmaindastri.model.SearchResponse
import com.example.sigmaindastri.model.SearchResult
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchViewModel() : ViewModel() {
    var searchResultsResponse:List<SearchResult> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")
    val apiClient = ApiClient()
    fun getProductList(searchRequest: SearchRequest) {
        val apiService = apiClient.getApiService()
        viewModelScope.launch {
            try {
                searchResultsResponse = apiService.search(
                    searchRequest).results
            }
            catch (e: Exception) {
                println( e.message.toString())
            }
        }
    }
}