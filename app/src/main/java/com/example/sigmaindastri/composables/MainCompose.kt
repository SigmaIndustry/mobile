package com.example.sigmaindastri.composables

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
import com.example.sigmaindastri.controller.SessionManager
import com.example.sigmaindastri.controller.mainGraph
import com.example.sigmaindastri.ui.theme.SigmaIndastriTheme
import com.example.sigmaindastri.viewmodels.LoginViewModel
import com.example.sigmaindastri.viewmodels.SearchViewModel
import com.example.sigmaindastri.viewmodels.SignUpViewModel


/// initial remember statements to initialize the navigation and drawer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainCompose(
    sessionManager: SessionManager,
    searchViewModel: SearchViewModel,
    loginViewModel: LoginViewModel,
    signUpViewModel: SignUpViewModel
) {
    val navController: NavHostController = rememberNavController()
    val drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
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
                            MainNavOption.ProfileComposable -> {
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
                    mainGraph(drawerState, sessionManager, searchViewModel, loginViewModel, signUpViewModel)
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
            MainNavOption.ProfileComposable,
            R.string.drawer_profile,
            R.drawable.ic_info,
            R.string.drawer_profile_description
        )
    )
}

