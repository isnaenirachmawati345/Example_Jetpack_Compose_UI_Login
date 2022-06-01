package com.example.firstcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstcompose.ui.theme.FirstComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //(drakTheme=false)
            FirstComposeTheme (darkTheme = false){
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column() {
                        //Greeting("Android")
                        //dipanggil fungsi header disini
                        HeaderLogin()
                        InputForm()
                        ActionItem()
                    //                        {
//                            Toast.makeText(this@MainActivity, "Login Clicked")
//                        }
                    }
                }
            }
        }
    }
}
@Composable
fun HeaderLogin() {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Login", fontSize = 36.sp)
        Spacer(modifier = Modifier.height(8.dp))
        Image(painter = painterResource(id = R.drawable.image),
            contentDescription ="Image App",
         modifier = Modifier.size(256.dp, 128.dp ),
        contentScale = ContentScale.Crop )
    }
}
@Composable
fun InputForm(){
    Column(modifier = Modifier
        .padding(horizontal = 16.dp)
        .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(32.dp))
        val email = remember {
            mutableStateOf("")
        }
        TextField(
            value = email.value,
            onValueChange = {email.value = it},
            placeholder = { Text(text = "Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        val password = remember {
            mutableStateOf("")
        }
        TextField(
            value = password.value,
            onValueChange = {password.value = it},
            placeholder = { Text(text = "Password")},
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth())
    }
}
@Composable
fun ActionItem() {

    Column(modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        {
        //untuk spasi
 Spacer(modifier = Modifier.height(32.dp))
//        val email = remember {
//            mutableStateOf("")
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Login")
        }
    }
}
//        Button(onClick = { /*TODO*/ }) {
//            Text(text = "Login")
//        }



@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}
//untuk menampilkan ui menggunakan showsystemnui = true
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    FirstComposeTheme {
        Column {

            HeaderLogin()
            InputForm()
            ActionItem()
            //Greeting("Android")
            //panggil header lagi

        }
    }
}