package org.example.multicalculator

import App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CalcView()
        }
    }
}

@Composable
fun CalcView() {
    val displayText = remember { mutableStateOf("0") }

    Column(modifier = Modifier
        .padding(horizontal = 0.dp)
        .background(Color.LightGray)
        .fillMaxSize()
        .height(350.dp)){
        Row {
            CalcDisplay(display = displayText)
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            Column {
                for (i in 7 downTo 1 step 3) {
                    CalcRow(display = displayText, startNum = i, numButtons = 3)
                }
                Row {
                    CalcNumericButton(number = 0, display = displayText)
                    CalcEqualsButton(display = displayText)
                    CalcClearButton(display = displayText)
                }
            }
            Column {
                val operations = listOf("+", "-", "*", "/")
                for (operation in operations) {
                    CalcOperationButton(operation = operation, display = displayText)
                }
            }
        }
    }
}

@Composable
fun CalcRow(display: MutableState<String>, startNum: Int, numButtons: Int) {
    val endNum = startNum + numButtons
    Row(modifier = Modifier
        .padding(0.dp)) {
        for (i in startNum until endNum) {
            CalcNumericButton(number = i, display = display)
        }
    }
}

@Composable
fun CalcDisplay(display: MutableState<String>) {
    Text(
        text = display.value,
        modifier = Modifier
            .height(100.dp)
            .padding(10.dp)
            .fillMaxWidth(),
        fontSize = 45.sp
    )
}

@Composable
fun CalcNumericButton(number: Int, display: MutableState<String>) {
    Button(
        onClick = { display.value += number.toString() },
        modifier = Modifier
            .padding(5.dp)
            .size(90.dp)
    ) {
        Text(text = number.toString(), fontSize = 35.sp)
    }
}

@Composable
fun CalcOperationButton(operation: String, display: MutableState<String>) {
    Button(
        /* logic will be added here when button is pressed*/
        onClick = {  },
        modifier = Modifier.padding(5.dp)
            .size(90.dp)
    ) {
        Text(text = operation, fontSize = 35.sp)
    }
}

@Composable
fun CalcEqualsButton(display: MutableState<String>) {
    Button(
        onClick = { display.value = "0" },
        modifier = Modifier.padding(5.dp)
            .size(90.dp)
    ) {
        Text(text = "=", fontSize = 35.sp)
    }
}

@Composable
fun CalcClearButton(display: MutableState<String>) {
    Button(
        onClick = { display.value = "0" },
        modifier = Modifier.padding(5.dp)
            .size(90.dp)
    ) {
        Text(text = "C", fontSize = 35.sp)
    }
}