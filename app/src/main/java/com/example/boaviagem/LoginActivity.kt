package com.example.boaviagem
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LoginActivity(navController: NavController) {
    GetLogin(navController = navController)
}


@Composable
fun GetLogin(navController: NavController) {
    val login = remember { mutableStateOf(TextFieldValue()) }
    val password = remember { mutableStateOf(TextFieldValue()) }

    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        GetImageLogo()
        GetEntryComponent(text = "Login", value = login, keyboardType = KeyboardType.Text)
        GetEntryComponent(text = "Senha", value = password, keyboardType = KeyboardType.Password)
        GetButtonComponent(login, password, navController)
    }
}

@Composable
fun GetEntryComponent(text: String, value: MutableState<TextFieldValue>, keyboardType: KeyboardType){
    Text(
        text = text,
        Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontSize = 24.sp,
    )

    OutlinedTextField(value = value.value,
        onValueChange = { newValue -> value.value = newValue },
        Modifier.padding(10.dp),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType)
    )
}

@Composable
fun GetButtonComponent(login: MutableState<TextFieldValue>, password: MutableState<TextFieldValue>, navController: NavController){
    val context = LocalContext.current

    Button(onClick = {
        if ((login.value.text == "root") and (password.value.text == "root"))
            navController.navigate("main")
        else
            Toast.makeText(context, "Login incorreto", Toast.LENGTH_SHORT).show()
    },
        Modifier.size(width = 200.dp, height = 50.dp)) {
        Text(text = "Logar")
    }
}

@Composable
fun GetImageLogo(){
    Image(painter = painterResource(id = R.drawable.logo) , contentDescription = "Minha logo")
}