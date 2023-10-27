package com.example.sigmaindastri

sealed class Route(route: String) {
    object Index: Route("/")
}