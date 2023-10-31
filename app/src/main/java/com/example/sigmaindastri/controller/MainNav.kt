package com.example.sigmaindastri.controller

import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.sigmaindastri.composables.NavRoutes
import com.example.sigmaindastri.composables.ProfileCompose
import com.example.sigmaindastri.composables.SearchScreenComposable


@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.mainGraph(drawerState: DrawerState, sessionManager: SessionManager, searchController: SearchController) {
    navigation(startDestination = MainNavOption.SearchScreenComposable.name, route = NavRoutes.MainRoute.name) {
        composable(MainNavOption.SearchScreenComposable.name){
            SearchScreenComposable(drawerState, searchController)
        }

        composable(MainNavOption.ProfileComposable.name){
            ProfileCompose(drawerState, sessionManager)
        }
    }
}

enum class MainNavOption {
    SearchScreenComposable,
    ProfileComposable,
}