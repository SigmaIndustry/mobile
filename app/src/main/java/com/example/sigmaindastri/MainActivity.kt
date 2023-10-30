package com.example.sigmaindastri

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.DatePicker
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sigmaindastri.controller.ApiClient
import com.example.sigmaindastri.controller.LoginController
import com.example.sigmaindastri.controller.SessionManager
import com.example.sigmaindastri.model.LoginRequest
import com.example.sigmaindastri.model.LoginResponse
import com.example.sigmaindastri.model.Role
import com.example.sigmaindastri.model.Route
import com.example.sigmaindastri.model.Sex
import com.example.sigmaindastri.ui.theme.SigmaIndastriTheme
import com.example.sigmaindastri.view.LoginView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Calendar
import java.util.Date

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sessionManager = SessionManager(this)
        val loginController = LoginController(sessionManager)
        setContent {
            SigmaIndastriTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Route.Index.url) {
                        composable(Route.Index.url) { Greeting(navController) }
                        composable(Route.Login.url) { LoginView(loginController, navController) }
                        composable(Route.Registration.url) { RegistrationView(navController) }
                    }
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationView(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var isValidEmail by remember { mutableStateOf(false) }
    var isValidPassword by remember { mutableStateOf(false) }
    var isValidFirstName by remember { mutableStateOf(false) }
    var isValidLastName by remember { mutableStateOf(false) }
    val emailRequiredChars = setOf('@', '.')



    var sex by remember { mutableStateOf(Sex.Male) }

    var role by remember { mutableStateOf(Role.User) }

    var birthDate by remember { mutableStateOf("") }

    val mContext = LocalContext.current
    val mCalendar = Calendar.getInstance()
    val mYear = mCalendar.get(Calendar.YEAR)
    val mMonth = mCalendar.get(Calendar.MONTH)
    val mDay = mCalendar.get(Calendar.DAY_OF_MONTH)
    mCalendar.time = Date()



    val mDatePickerDialog = DatePickerDialog(
        mContext,
        { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
            birthDate = "$mYear-$mMonth-$mDayOfMonth"
        }, mYear, mMonth, mDay
    )


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = email,
            onValueChange = { input ->
                email = input
                isValidEmail = input.isNotEmpty() && input.all(emailRequiredChars::contains)
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
        OutlinedTextField(
            value = firstName,
            onValueChange = { input ->
                firstName = input
                isValidFirstName = input.isNotEmpty()
            },
            label = { Text("First Name") },
        )

        OutlinedTextField(
            value = lastName,
            onValueChange = { input ->
                lastName = input
                isValidLastName = input.isNotEmpty()
            },
            label = { Text("Last Name") },
        )

        Button(onClick = { mDatePickerDialog.show() }) {
            Text(text = "Pick birth date: $birthDate", color = Color.White)
        }
        Row()
        {
            Text("Choose your sex")
            Button(
                onClick = {
                    sex = Sex.Male
                },
                colors = ButtonDefaults.buttonColors(containerColor = if (sex == Sex.Male) Color(0xFF6650a4) else Color.Gray)
            ) {
                Text("Male")
            }
            Button(
                onClick = { sex = Sex.Female },
                colors = ButtonDefaults.buttonColors(containerColor = if (sex == Sex.Female) Color(0xFF6650a4) else Color.Gray)
            ) {
                Text("Female")
            }
        }

        Row()
        {
            Text("Choose your role")
            Button(
                onClick = { role = Role.User },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (role == Role.User) Color(
                        0xFF6650a4
                    ) else Color.Gray
                )
            ) {

                Text("User")
            }
            Button(
                onClick = { role = Role.ServiceProvider },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (role == Role.ServiceProvider) Color(
                        0xFF6650a4
                    ) else Color.Gray
                )
            ) {

                Text("Service provider")
            }
        }

        Button(
            onClick = {
//                stateManager.httpManager.getUserAPI().userRegistration(
//                    User(
//                        email,
//                        password,
//                        firstName,
//                        lastName,
//                        birthDate.value,
//                        sex.name,
//                        "",
//                        role.name
//                    )
//                ).enqueue(object : Callback<LoginResponse> {
//                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
//                        // Error logging in
//                    }
//                }
//                )
            },
            enabled = isValidEmail && isValidPassword && isValidLastName && isValidFirstName
        ) {
            Text(text = "Sign up", fontSize = 20.sp)
        }
    }
}
