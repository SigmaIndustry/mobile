package com.example.sigmaindastri

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "startPage") {
                        composable("startPage") { Greeting(navController = navController,name = "Vadym sosi bibijon") }
                        composable("auth") { AuthView() }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(navController: NavHostController, name: String, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Button(onClick = { navController.navigate("auth") }) {
            Text(text = "To auth")
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    SigmaIndastriTheme {
//        Greeting("Android")
//    }
//}

@Composable
fun AuthView(){
    Text(
        text = "Hello from auth view"
    )
}