package com.example.sigmaindastri.controller

import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.sigmaindastri.Composables.AuthorizationComposable
import com.example.sigmaindastri.Composables.NavRoutes
import com.example.sigmaindastri.Composables.SearchScreenComposable


@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.mainGraph(drawerState: DrawerState) {
    navigation(startDestination = MainNavOption.SearchScreenComposable.name, route = NavRoutes.MainRoute.name) {
        composable(MainNavOption.SearchScreenComposable.name){
            SearchScreenComposable(drawerState)
        }

        composable(MainNavOption.AuthorizationComposable.name){
            AuthorizationComposable(drawerState)
        }
    }
}

enum class MainNavOption {
    SearchScreenComposable,
    AuthorizationComposable,
}