package com.cansa.distri

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cansa.distri.navigation.NavManager
import com.cansa.distri.ui.theme.ControlDistributionTheme
import com.cansa.distri.viewModels.LoginViewModel
import com.cansa.distri.viewModels.PointViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val loginVM : LoginViewModel by viewModels()
        val pointVM : PointViewModel by viewModels()

        setContent {
            ControlDistributionTheme {
                Scaffold (modifier = Modifier.fillMaxSize()) { innerpadding ->
                    NavManager(loginVM, pointVM, innerpadding)

                    //LoginView(onLoginClick = {text, text2 -> text+text2}, onRegisterClick = {}, modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ControlDistributionTheme {
        Greeting("Android")
    }
}