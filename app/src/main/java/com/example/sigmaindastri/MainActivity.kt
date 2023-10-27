package com.example.sigmaindastri

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sigmaindastri.ui.theme.SigmaIndastriTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SigmaIndastriTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val stateManager by remember { mutableStateOf(StateManager(navController, "")) }
                    NavHost(navController = navController, startDestination = Route.Index.url) {
                        composable(Route.Index.url) { Greeting(navController = navController,name = "Vadym sosi bibijon") }
                        composable(Route.Login.url) { LoginView() }
                        composable(Route.Registration.url) { RegistrationView() }
                    }
                }
            }
        }
    }
}
@Composable
fun Greeting(navController: NavHostController, name: String) {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Button(
            onClick = { navController.navigate("login") },
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginView(){
    var email by remember { mutableStateOf("")}
    var password by remember { mutableStateOf("")}
    var isValidEmail by remember { mutableStateOf(false) }
    var isValidPassword by remember { mutableStateOf(false) }
    val emailRequiredChars = setOf('@', '.')
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Hello from login view ${email}")
        OutlinedTextField(value = email,
            onValueChange = { input ->
                email = input
                isValidEmail = input.isNotEmpty() && input.any(emailRequiredChars::contains)
            },
            label = { Text("Email") },
        )
        OutlinedTextField(value = password,
            onValueChange = { input ->
                password = input
                isValidPassword = input.isNotEmpty() && input.length >= 6
            },
            label = { Text("Email") },
        )
        Button(onClick = {  }) {
            Text(text = "Log in", fontSize = 20.sp)
        }
    }
}
@Composable
fun RegistrationView(){
    Text(
        text = "Hello from registration view"
    )
}
