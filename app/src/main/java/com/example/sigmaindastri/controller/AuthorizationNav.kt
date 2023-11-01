package com.example.sigmaindastri.controller

import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.sigmaindastri.composables.AuthorizationComposable
import com.example.sigmaindastri.composables.LoginCompose
import com.example.sigmaindastri.composables.ProfileTokenCompose
import com.example.sigmaindastri.composables.SignUpCompose
import com.example.sigmaindastri.viewmodels.LoginViewModel
import com.example.sigmaindastri.viewmodels.SignUpViewModel

@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.profileGraph(
    drawerState: DrawerState,
    sessionManager: SessionManager,
    navController: NavHostController,
    loginViewModel: LoginViewModel,
    signUpViewModel: SignUpViewModel
) {
    navigation(startDestination = ProfileNavOption.AuthorizationComposable.name, route = MainNavOption.ProfileComposable.name) {
        composable(ProfileNavOption.AuthorizationComposable.name){
            AuthorizationComposable( drawerState, navController)
        }
        composable(ProfileNavOption.LoginCompose.name){
            LoginCompose(sessionManager, drawerState, navController,loginViewModel)
        }

        composable(ProfileNavOption.SignUpCompose.name){
            SignUpCompose(sessionManager, drawerState, navController, signUpViewModel)
        }
        composable(ProfileNavOption.ProfileTokenCompose.name){
            ProfileTokenCompose( drawerState, sessionManager)
        }
    }
}
enum class ProfileNavOption {
    AuthorizationComposable,
    LoginCompose,
    SignUpCompose,
    ProfileTokenCompose
}