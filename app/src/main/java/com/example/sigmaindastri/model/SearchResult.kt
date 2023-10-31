package com.example.sigmaindastri.model

import com.google.gson.annotations.SerializedName

data class SearchResult(

    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("pictures")
    var pictures: Array<String>,

    @SerializedName("description")
    var description: String,

    @SerializedName("price")
    var price: Int,

    @SerializedName("category")
    var category: String,

    @SerializedName("rating")
    var rating: Int,

    @SerializedName("provider")
    var provider: Int

)
