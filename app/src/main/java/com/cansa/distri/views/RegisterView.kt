package com.cansa.distri.views



import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.cansa.distri.viewModels.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterView(
    loginVM: LoginViewModel,
    navController: NavController,
    onRegisterClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordConfirm by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Regístrate",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation(),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = passwordConfirm,
            onValueChange = { passwordConfirm = it },
            label = { Text("Confirmar contraseña") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation(),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                loginVM.login(email,password){ navController.navigate("Home")  }
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = email.isNotBlank() && password.isNotBlank() && (password == passwordConfirm)
        ) {
            Text("Registrarse")
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(onClick = { navController.navigate("Login") }) {
            Text("¿Ya tienes cuenta? Inicia sesión")
        }
        if (loginVM.showAlert){
            BasicAlertDialog(
                onDismissRequest = {
                    // Dismiss the dialog when the user clicks outside the dialog or on the back
                    // button. If you want to disable that functionality, simply use an empty
                    // onDismissRequest.
                    loginVM.showAlert = false

                }){
                Surface(
                    modifier = Modifier
                        .wrapContentWidth()
                        .wrapContentHeight(),
                    shape = MaterialTheme.shapes.large,
                    tonalElevation = AlertDialogDefaults.TonalElevation
                ) {
                    Column(modifier = Modifier. padding(16.dp)) {
                        Text(text ="Hubo un error", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                        Spacer(modifier = Modifier. height(18.dp))
                        Text(text ="Verifique su email y contraseña")
                        Spacer(modifier = Modifier. height(24.dp))
                        TextButton(onClick = { loginVM.showAlert = false },
                            modifier = Modifier. align(Alignment. End)
                        ) {
                            Text("Aceptar")
                        }
                    }
                }
            }

        }//If
    }
}

