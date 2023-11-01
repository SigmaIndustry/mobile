package com.example.sigmaindastri.composables

import android.annotation.SuppressLint
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.sigmaindastri.appui.appbar.AppBar
import com.example.sigmaindastri.controller.SessionManager
//TODO зробити зовнішній вигляд профіля приблизно, потім перепишеться
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileTokenCompose(drawerState: DrawerState, sessionManager:SessionManager){
        Scaffold(
        topBar = {
            AppBar(
                drawerState = drawerState,
            )
        }){
            println(
                if (sessionManager.fetchAuthToken() != null) {
                    sessionManager.fetchAuthToken()
                } else {
                    "null"
                }
            )

            (if (sessionManager.fetchAuthToken() != null) {
                sessionManager.fetchAuthToken()
            } else {
                "null"
            })?.let { Text(text = it) }
        }
    }
