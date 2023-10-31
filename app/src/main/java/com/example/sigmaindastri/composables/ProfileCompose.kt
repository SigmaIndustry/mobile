package com.example.sigmaindastri.composables

import android.annotation.SuppressLint
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.sigmaindastri.appui.appbar.AppBar
import com.example.sigmaindastri.controller.profileGraph
import com.example.sigmaindastri.controller.LoginController
import com.example.sigmaindastri.controller.MainNavOption
import com.example.sigmaindastri.controller.SessionManager
import com.example.sigmaindastri.controller.SignUpController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileCompose(drawerState:DrawerState, sessionManager: SessionManager) {
    val loginController = LoginController(sessionManager)
    val signUpController = SignUpController(sessionManager)
    val navController: NavHostController = rememberNavController()
    Scaffold(
        topBar = {
            AppBar(
                drawerState = drawerState,
            )
        }
    ) {
        NavHost(
            navController,
            startDestination = MainNavOption.ProfileComposable.name
        ) {
            profileGraph(drawerState, loginController, signUpController, navController)
        }
    }
}