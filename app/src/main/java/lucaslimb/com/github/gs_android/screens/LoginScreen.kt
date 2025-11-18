package lucaslimb.com.github.gs_android.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import lucaslimb.com.github.gs_android.R

@Composable
fun LoginScreen(modifier: Modifier = Modifier, navController: NavController) {

    var usuario = remember { mutableStateOf("") }
    var senha = remember { mutableStateOf("") }
    var erro = remember { mutableStateOf("") }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFED145B))
            .padding(32.dp)
    ) {
        Text(
            text = "Usuário",
            modifier = Modifier.padding(bottom = 8.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            color = colorResource(id = R.color.teal_700)
        )
        OutlinedTextField(
            value = usuario.value,
            onValueChange = { usuario.value = it },
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = colorResource(id = R.color.teal_700),
                focusedBorderColor = colorResource(id = R.color.teal_700)
            ),
            shape = RoundedCornerShape(16.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Senha",
            modifier = Modifier.padding(bottom = 8.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            color = colorResource(id = R.color.teal_700)
        )
        OutlinedTextField(
            value = senha.value,
            onValueChange = { senha.value = it },
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = colorResource(id = R.color.teal_700),
                focusedBorderColor = colorResource(id = R.color.teal_700)
            ),
            shape = RoundedCornerShape(16.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Button(
            onClick = {
                if(usuario.equals("admin") && senha.equals("123456")) {
                    navController.navigate("menu")
                    erro = mutableStateOf("")
                } else {
                    erro =  mutableStateOf("Usuário invalido na tela")
                }
                      },
            colors = ButtonDefaults.buttonColors(Color.White),
            modifier = Modifier.align(Alignment.Center)
        ) {
            if(erro.toString().isEmpty()){
                Text(
                    text = erro.toString(),
                    fontSize = 20.sp,
                    color = Color.Red
                )
            }
            Text(
                text = "ENTRAR",
                fontSize = 20.sp,
                color = Color.Blue
            )
        }
    }
}
