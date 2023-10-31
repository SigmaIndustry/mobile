package com.example.sigmaindastri.composables

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerState
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sigmaindastri.controller.SignUpController
import com.example.sigmaindastri.model.Role
import com.example.sigmaindastri.model.Sex
import java.util.Calendar
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpCompose(
    signUpController: SignUpController,
    drawerState: DrawerState,
    navController: NavHostController
) {
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
        { _: DatePicker, year: Int, month: Int, day: Int ->
            birthDate = "$year-$month-$day"
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
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (sex == Sex.Male) Color(
                        0xFF6650a4
                    ) else Color.Gray
                )
            ) {
                Text("Male")
            }
            Button(
                onClick = { sex = Sex.Female },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (sex == Sex.Female) Color(
                        0xFF6650a4
                    ) else Color.Gray
                )
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
                signUpController.signUpRequest(
                    email,
                    password,
                    firstName,
                    lastName,
                    birthDate,
                    if (sex == Sex.Male) {
                        "M"
                    } else {
                        "F"
                    },
                    "",
                    if (role == Role.User) {
                        "G"
                    } else {
                        "P"
                    }
                )
                //navController.navigate("token")
            },
            enabled = isValidEmail && isValidPassword && isValidLastName && isValidFirstName
        ) {
            Text(text = "Sign up", fontSize = 20.sp)
        }
    }
}