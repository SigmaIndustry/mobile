package com.example.sigmaindastri

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import java.util.Date



class HttpManager(userToken: String) {
    private lateinit var userAPI: UserAPI
    var userToken = userToken
    fun getUserAPI(): UserAPI {

        // Initialize ApiService if not initialized yet
        if (!::userAPI.isInitialized) {
            val retrofit = retrofit2.Retrofit.Builder()
                .baseUrl("https://backend-ivory-alpha.vercel.app")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            userAPI = retrofit.create(UserAPI::class.java)
        }
        return userAPI
    }
}

interface UserAPI {
    @POST("security/registration")
    @FormUrlEncoded
    fun userRegistration(@Body requestBody: User): Call<LoginResponse>
}
