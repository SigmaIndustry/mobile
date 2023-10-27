package com.example.sigmaindastri

import androidx.navigation.NavController

class StateManager(navCtrl: NavController, userToken: String) {
    val navController: NavController = navCtrl
    val httpManager = HttpManager(userToken)

    fun save() {
       print("Save me latter ${httpManager.userToken}")
    }
}