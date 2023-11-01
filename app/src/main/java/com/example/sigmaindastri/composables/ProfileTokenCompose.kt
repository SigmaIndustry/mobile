package com.example.sigmaindastri.composables

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import com.example.sigmaindastri.appui.appbar.AppBar
import com.example.sigmaindastri.controller.SessionManager
import com.example.sigmaindastri.viewmodels.LoginViewModel
import com.example.sigmaindastri.viewmodels.SignUpViewModel

//TODO зробити зовнішній вигляд профіля приблизно, потім перепишеться
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileTokenCompose(drawerState: DrawerState, sessionManager: SessionManager) {
    Scaffold(
        topBar = {
            AppBar(
                drawerState = drawerState,
            )
        }) { padding ->
        println(
            if (sessionManager.fetchAuthToken() != null) {
                sessionManager.fetchAuthToken()
            } else {
                "nullTokenNow"
            }
        )

        (if (sessionManager.fetchAuthToken() != null) {
            sessionManager.fetchAuthToken()
        } else {
            "null"
        })?.let {
            Text(
                text = it,
                modifier = Modifier.padding(paddingValues = padding)
            )
        }
    }
}

