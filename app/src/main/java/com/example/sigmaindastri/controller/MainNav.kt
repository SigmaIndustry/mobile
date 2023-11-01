package com.example.sigmaindastri.controller

import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.sigmaindastri.composables.NavRoutes
import com.example.sigmaindastri.composables.ProfileCompose
import com.example.sigmaindastri.composables.SearchScreenComposable
import com.example.sigmaindastri.viewmodels.LoginViewModel
import com.example.sigmaindastri.viewmodels.SearchViewModel
import com.example.sigmaindastri.viewmodels.SignUpViewModel


@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.mainGraph(
    drawerState: DrawerState,
    sessionManager: SessionManager,
    searchViewModel: SearchViewModel,
    loginViewModel: LoginViewModel,
    signUpViewModel:SignUpViewModel) {
    navigation(startDestination = MainNavOption.SearchScreenComposable.name, route = NavRoutes.MainRoute.name) {
        composable(MainNavOption.SearchScreenComposable.name){
            SearchScreenComposable(drawerState, searchViewModel)
        }

        composable(MainNavOption.ProfileComposable.name){
            ProfileCompose(drawerState, sessionManager,loginViewModel, signUpViewModel)
        }
    }
}

enum class MainNavOption {
    SearchScreenComposable,
    ProfileComposable,
}