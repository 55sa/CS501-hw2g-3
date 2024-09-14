package com.example.hw2g_3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hw2g_3.ui.theme.Hw2g3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Hw2g3Theme {
                Calculator()
            }
        }
    }
}

fun parse( expression: String ): String{
    // parse the expression and calculate the answer
    val list = expression.split(" ")
    val operators = listOf("+", "-", "*", "/", "%")
    for (index in list.indices) {
        var element = list[index]
        if (element in operators){
            if (index == list.size){
                return "Invalid Expression"
            }
            if (element == "/" && list[index + 1].toFloat() == 0f) {
                return "Cannot Divide by 0"
            }
        }
    }
    return expression
}

@Composable
fun Calculator(){
    Column(modifier=Modifier.fillMaxSize().padding(60.dp)){
        var input by remember { mutableStateOf("") }
        var expression by remember { mutableStateOf("") }
//        var operation by remember { mutableStateOf("") }
//        var result by remember { mutableStateOf("0.0") }

        TextField(
            value = input,
            onValueChange = { input = it },
            label = { Text("Enter Expression") }
        )

        Column(modifier = Modifier
//                .padding(padding)
//                .clickable(onClick = onClick)
                .fillMaxSize().padding(20.dp)){
            Row {
                Button(
                    onClick = {
                        input += " + "

                    }){
                    Text("+")
                }
                Button(
                    onClick = {
                        input += " - "

                    }){
                    Text("-")
                }
                Button(
                    onClick = {
                        input += " * "

                    }){
                    Text("*")
                }
                Button(
                    onClick = {
                        input += " / "

                        }){
                    Text("/")
                }
            }
            Row {
                Button(
                    onClick = {
                        input += "7"

                }){
                    Text("7")
                }
                Button(
                    onClick = {
                        input += "8"

                    }){
                    Text("8")
                }
                Button(
                    onClick = {
                        input += "9"

                    }){
                    Text("9")
                }
                Button(
                    onClick = {
                        input += " % "

                    }){
                    Text("%")
                }
            }
            Row {
                Button(
                    onClick = {
                        input += "4"

                    }){
                    Text("4")
                }
                Button(
                    onClick = {
                        input += "5"

                    }){
                    Text("5")
                }
                Button(
                    onClick = {
                        input += "6"

                    }){
                    Text("6")
                }
                Button(
                    onClick = {
                        input = parse(expression)
                    }){
                    Text("=")
                }
            }
            Row {
                Button(
                    onClick = {
                        input += "1"
                        
                    }){
                    Text("1")
                }
                Button(
                    onClick = {
                        input += "2"
                        
                    }){
                    Text("2")
                }
                Button(
                    onClick = {
                        input += "3"
                        
                    }){
                    Text("3")
                }

            }
            Row(modifier=Modifier.offset(x = 59.dp)) {
                Button(
                    onClick = {
                        input += "0"
                        
                    }){
                    Text("0")
                }
                Button(
                    onClick = {
                        input += "."
                        
                    }){
                    Text(".")
                }

            }
        }
    }
}



fun Multiply(x: Float, y: Float): Float {
    return (x * y).toFloat()
}

fun Add(x: Float, y: Float): Float {
    return (x + y).toFloat()
}

fun Subtract(x: Float, y: Float): Float{
    return (x - y).toFloat()
}

fun Modulo(x: Float, y: Float): Float{
    return (x % y).toFloat()
}

fun Deviation(x: Float, y: Float): Float{
    return (x / y).toFloat()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Hw2g3Theme {
        Calculator()
    }
}