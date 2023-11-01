package com.example.sigmaindastri

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sigmaindastri.controller.SessionManager
import com.example.sigmaindastri.model.Route
import com.example.sigmaindastri.ui.theme.SigmaIndastriTheme
import com.example.sigmaindastri.composables.MainCompose
import com.example.sigmaindastri.viewmodels.SearchViewModel


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sessionManager = SessionManager(this)
        //val loginController = LoginController(sessionManager)
        //val signUpController = SignUpController(sessionManager)
        val searchViewModel by viewModels<SearchViewModel>()
        setContent {
            SigmaIndastriTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainCompose(sessionManager, searchViewModel)
//                    val navController = rememberNavController()
//                    NavHost(navController = navController, startDestination = Route.Index.url) {
//                        composable(Route.Index.url) { Greeting(navController) }
//                        composable(Route.Login.url) { LoginCompose(loginController, navController) }
//                        composable(Route.Registration.url) { SignUpCompose(signUpController, navController) }
//                        composable("tokenView") { Token(sessionManager)}
//                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(navController: NavController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(
            onClick = { navController.navigate(Route.Login.url) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 32.dp)
        ) {
            Text(text = "Log in", fontSize = 40.sp)
        }
        Button(
            onClick = { navController.navigate("registration") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 32.dp)
        ) {
            Text(text = "Sign up", fontSize = 40.sp)
        }

    }
}

@Composable
fun Token(sessionManager: SessionManager){
    (if(sessionManager.fetchAuthToken() != null){sessionManager.fetchAuthToken()}else{"null"})?.let { Text(text = it) }
}
