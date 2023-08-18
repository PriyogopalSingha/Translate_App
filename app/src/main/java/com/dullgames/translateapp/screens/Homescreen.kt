package com.dullgames.translateapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.dullgames.translateapp.models.BaseModel
import androidx.lifecycle.viewmodel.compose.viewModel
data class Lang(
//    @DrawableRes val icon: Int,
    val name: String,
    val symbol: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel = viewModel()){
    val translation by viewModel.translation.collectAsState()
    val languages = listOf(
        Lang("Persian", "fa"),
        Lang("English", "en"),
        Lang("Chinese", "chi"),
        Lang("Turkish", "tr")
    )
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Translator") })
        }
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(it)) {
            when(val result = translation){
                is BaseModel.Success -> {
                    Text(text = result.data.responseData.translatedText)
                }
                is BaseModel.Error -> {
                    Text(text = "Error")
                }
                is BaseModel.Loading -> {
                    CircularProgressIndicator()
                }
                null ->{
                    Text(text = "Nothing to Show")
                }
            }
            Button(onClick = {
                viewModel.translate(
                    query = "hello",
                    source = "en",
                    target = "tr"
                )
            }) {
                Text("Test Translation")
            }

        }
    }
}