package com.example.sigmaindastri.Composables

import android.annotation.SuppressLint
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.sigmaindastri.appui.appbar.AppBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreenComposable(drawerState: DrawerState) {
    Scaffold(
        topBar = {
            AppBar(
                drawerState = drawerState,
            )
        }
    ) {
        Text("This is search screen")
    }
}