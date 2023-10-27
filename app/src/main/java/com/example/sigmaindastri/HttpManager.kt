package com.example.sigmaindastri

import retrofit2.create
import retrofit2.http.Body
import retrofit2.http.POST
import java.util.Date

enum class Sex {
    Male, Female
}
data class RegistrationFields(val email: String, val password: String, val firstName: String, val lastName: String, val birthDate: Date, val sex: Sex, val photoUrl: String);
class HttpManager(userToken: String) {
    var userToken = userToken
    val httpClient = retrofit2.Retrofit.Builder()
        .baseUrl("https://backend-ivory-alpha.vercel.app")
        .build()
    val userService = httpClient.create(UserAPI::class.java)
}

interface UserAPI {
    @POST("security/registration")
    suspend fun userRegistration(@Body requestBody: RegistrationFields)
}