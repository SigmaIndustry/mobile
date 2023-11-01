package com.example.sigmaindastri.model

import com.google.gson.annotations.SerializedName

data class SearchResponse (
    @SerializedName("code")
    var statusCode: Int,

    @SerializedName("size")
    var size: Int,

    @SerializedName("results")
    var results: List<SearchResult>
)



