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
import com.example.sigmaindastri.controller.MainNavOption
import com.example.sigmaindastri.controller.SessionManager
import com.example.sigmaindastri.viewmodels.LoginViewModel
import com.example.sigmaindastri.viewmodels.SignUpViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileCompose(drawerState:DrawerState, sessionManager: SessionManager,loginViewModel: LoginViewModel, signUpViewModel: SignUpViewModel) {
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
            profileGraph(drawerState, sessionManager, navController,loginViewModel, signUpViewModel)
        }
    }
}