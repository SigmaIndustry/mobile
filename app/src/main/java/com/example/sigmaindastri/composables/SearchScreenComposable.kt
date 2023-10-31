package com.example.sigmaindastri.composables

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.sigmaindastri.appui.appbar.AppBar
import com.example.sigmaindastri.controller.SearchController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun SearchScreenComposable(drawerState: DrawerState, searchController: SearchController) {
    var text by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current
   // val focusManager = LocalFocusManager.current

    Scaffold(
        topBar = {
            AppBar(
                drawerState = drawerState,
            )
        }
    ) {innerPading->
        Column(
            modifier = Modifier.padding(innerPading),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = text,
                onValueChange = { text = it },
                label = { Text("Search") },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null) },
                keyboardActions = KeyboardActions(onSearch = {
                    searchController.searchRequest(
                        text,
                        10,
                        0,
                        0,
                        1000000,
                        "string",
                        0,
                        false
                    )
                    // Hide the keyboard after submitting the search
                    keyboardController?.hide()

                }
            )
            )
        }
    }
}