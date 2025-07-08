package com.cansa.distri.viewModels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel(){

    private val auth: FirebaseAuth = Firebase.auth

    var showAlert by mutableStateOf(false)

    fun login(email: String, password: String, onSucces: ()->Unit){
        viewModelScope.launch {
            try {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if(task.isSuccessful){
                            onSucces()
                        }else{
                            Log.d("Error inicio de sesion","Verifique su email y contraseña")
                            showAlert = true
                        }
                    }

            }catch (e: Error){
                Log.d("Ocurrio un error", "${e.message}")
            }
        }

    }

}