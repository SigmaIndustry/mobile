package com.example.sigmaindastri.Composables

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.sigmaindastri.R
import com.example.sigmaindastri.appui.appdrawer.AppDrawerContent
import com.example.sigmaindastri.appui.appdrawer.AppDrawerItemInfo
import com.example.sigmaindastri.controller.MainNavOption
import com.example.sigmaindastri.controller.mainGraph
import com.example.sigmaindastri.ui.theme.SigmaIndastriTheme


/// initial remember statements to initialize the navigation and drawer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainCompose(
    navController: NavHostController = rememberNavController(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
    //vm: IntroViewModel = hiltViewModel()
) {
    SigmaIndastriTheme {
        Surface {
            ModalNavigationDrawer(
                drawerState = drawerState,
                drawerContent = {
                    AppDrawerContent(
                        drawerState = drawerState,
                        menuItems = DrawerParams.drawerButtons,
                        defaultPick = MainNavOption.SearchScreenComposable
                    ) { onUserPickedOption ->
                        when (onUserPickedOption) {
                            MainNavOption.SearchScreenComposable -> {
                                navController.navigate(onUserPickedOption.name) {
                                    popUpTo(NavRoutes.MainRoute.name)
                                }
                            }
                            MainNavOption.AuthorizationComposable -> {
                                navController.navigate(onUserPickedOption.name) {
                                    popUpTo(NavRoutes.MainRoute.name)
                                }
                            }
                        }
                    }
                }
            ) {
                //val isOnboarded = vm.isOnboarded.collectAsState()
                NavHost(
                    navController,
                    startDestination = NavRoutes.MainRoute.name
                ) {
                    mainGraph(drawerState)
                }
            }
        }
    }
}


enum class NavRoutes {
    MainRoute
}

object DrawerParams {
    val drawerButtons = arrayListOf(
        AppDrawerItemInfo(
            MainNavOption.SearchScreenComposable,
            R.string.drawer_search,
            R.drawable.ic_home,
            R.string.drawer_search_description
        ),
        AppDrawerItemInfo(
            MainNavOption.AuthorizationComposable,
            R.string.drawer_profile,
            R.drawable.ic_info,
            R.string.drawer_profile_description
        )
    )
}

