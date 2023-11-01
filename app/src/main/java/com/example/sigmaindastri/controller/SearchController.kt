package com.example.sigmaindastri.controller

//import com.example.sigmaindastri.model.LoginRequest
//import com.example.sigmaindastri.model.LoginResponse
//import com.example.sigmaindastri.model.SearchRequest
//import com.example.sigmaindastri.model.SearchResponse
//import com.google.gson.annotations.SerializedName
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//
//class SearchController(val sessionManager: SessionManager) {
//    var apiClient = ApiClient()
//    fun searchRequest(
//        searchQuery: String,
//        pageLimit: Int,
//        pageOffset: Int,
//        minPrice: Int,
//        maxPrice: Int,
//        category: String,
//        minRating: Int,
//        hasReviews: Boolean
//    ): SearchResponse {
//        lateinit var requestResponse: SearchResponse
//        apiClient.getApiService()
//            .search(
//                SearchRequest(
//                    searchQuery,
//                    pageLimit,
//                    pageOffset,
//                    minPrice,
//                    maxPrice,
//                    category,
//                    minRating,
//                    hasReviews
//                )
//            )
//            .enqueue(object : Callback<SearchResponse> {
//                override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
//                    // Error logging in
//                }
//
//                override fun onResponse(
//                    call: Call<SearchResponse>,
//                    response: Response<SearchResponse>
//                ) {
//                    val searchResponse = response.body()
//
//                    if (searchResponse?.statusCode == 200) {
//                         requestResponse = searchResponse
//                    } else {
//                        throw Exception("Unable to get data")
//                    }
//                }
//            })
//        return requestResponse
//    }
//
//}