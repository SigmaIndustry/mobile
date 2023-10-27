package com.example.sigmaindastri

sealed class Route(url: String) {
    object Index: Route("/")
    object Login: Route("login")
    object Registration: Route("registration")
}
