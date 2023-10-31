package com.example.sigmaindastri.controller

import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.sigmaindastri.composables.AuthorizationComposable
import com.example.sigmaindastri.composables.LoginCompose
import com.example.sigmaindastri.composables.SignUpCompose

@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.profileGraph(
    drawerState: DrawerState,
    loginController: LoginController,
    signUpController: SignUpController,
    navController: NavHostController,
) {
    navigation(startDestination = ProfileNavOption.AuthorizationComposable.name, route = MainNavOption.ProfileComposable.name) {
        composable(ProfileNavOption.AuthorizationComposable.name){
            AuthorizationComposable( drawerState, navController)
        }
        composable(ProfileNavOption.LoginCompose.name){
            LoginCompose(loginController, drawerState, navController)
        }

        composable(ProfileNavOption.SignUpCompose.name){
            SignUpCompose(signUpController, drawerState, navController)
        }
    }
}
enum class ProfileNavOption {
    AuthorizationComposable,
    LoginCompose,
    SignUpCompose,
}