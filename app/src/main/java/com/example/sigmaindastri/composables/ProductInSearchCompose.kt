package com.example.sigmaindastri.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.sigmaindastri.model.SearchResult


@Composable
fun ProductInSearchCompose(searchResult: SearchResult) {
    Column {
//        AsyncImage(
//            model = searchResult.pictures[0],
//            contentDescription = "Translated description of what the image contains"
//        )
        Text(searchResult.name)
        Text(searchResult.description)
    }
}