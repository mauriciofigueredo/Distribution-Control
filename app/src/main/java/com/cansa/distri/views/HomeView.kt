package com.cansa.distri.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Homeview(){
    Scaffold { innerPadding->
        HomeContent(innerPadding)
    }
}


@Composable
fun HomeContent( innerPadding : PaddingValues
){
    Column( modifier = Modifier.padding(innerPadding)) {
        Text("Home view")
    }
}