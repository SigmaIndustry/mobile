package com.example.sigmaindastri

sealed class Route(val url: String) {
    object Index: Route("/")
    object Login: Route("login")
    object Registration: Route("registration")
}
