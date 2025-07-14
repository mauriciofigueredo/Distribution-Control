package com.cansa.distri.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cansa.distri.viewModels.LoginViewModel
import com.cansa.distri.viewModels.PointViewModel
import com.cansa.distri.views.Homeview
import com.cansa.distri.views.LoginView
import com.cansa.distri.views.RegisterView

@Composable
fun NavManager(loginVM: LoginViewModel, pointVM: PointViewModel, innerPadding : PaddingValues ){

    val navController = rememberNavController()
    NavHost(navController=navController, startDestination = "Login"){
        composable("Login"){
            LoginView(loginVM, navController, onRegisterClick = {}, modifier = Modifier.padding(innerPadding))
        }

        composable("Home") { Homeview() }

        composable("Register"){
            RegisterView(loginVM, navController, onRegisterClick = {}, modifier = Modifier.padding(innerPadding))
        }
    }

}