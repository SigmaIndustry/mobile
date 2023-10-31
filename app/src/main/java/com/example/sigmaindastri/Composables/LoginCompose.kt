package com.example.sigmaindastri.Composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sigmaindastri.controller.LoginController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginCompose(loginController: LoginController, navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var isValidEmail by remember { mutableStateOf(false) }
    var isValidPassword by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Hello from login view ${email}")
        OutlinedTextField(
            value = email,
            onValueChange = { input ->
                email = input
                isValidEmail = input.isNotEmpty()
            },
            label = { Text("Email") },
        )
        OutlinedTextField(
            value = password,
            onValueChange = { input ->
                password = input
                isValidPassword = input.length >= 6
            },
            label = { Text("Password") },
        )
        Button(onClick = {
            loginController.loginRequest(email, password)
            navController.navigate("token")
        }, enabled = isValidEmail && isValidPassword) {
            Text(text = "Log in", fontSize = 20.sp)
        }
    }
}