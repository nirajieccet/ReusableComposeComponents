package com.example.pocreusablecomponents.ui

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pocreusablecomponents.ui.theme.POCReusableComponentsTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ButtonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            POCReusableComponentsTheme {
                ButtonUi()
            }
        }
    }
}

@Composable
fun ButtonUi() {
    val isButtonEnabled = remember { mutableStateOf(false) }
    val showToastState = remember { mutableStateOf(false) }

    if (showToastState.value) {
        showToast(LocalContext.current, "Custom Button")
        showToastState.value = false
    }

    Box(modifier = Modifier.padding(16.dp)) {
        Column(modifier = Modifier.padding(top = 10.dp)) {
            val isLoading = remember { mutableStateOf(false) }
            CommonButton(
                text = "Click Me to show",
                onClick = {
                    showToastState.value = true
                },
                modifier = Modifier.padding(8.dp)
            )
            CommonButton(
                text = "Click Me",
                onClick = { /*TODO*/ },
                backgroundColor = Color.Gray,
                modifier = Modifier
                    .padding(8.dp)
                    .width(200.dp)
            )
            CommonButton(
                text = "Click Me",
                onClick = { /*TODO*/ },
                backgroundColor = Color.Gray,
                contentColor = Color.Black,
                modifier = Modifier
                    .padding(8.dp)
                    .width(300.dp),
                shape = RoundedCornerShape(10.dp)
            )
            CommonButton(
                text = "Click Me",
                onClick = { /*TODO*/ },
                backgroundColor = Color.LightGray,
                contentColor = Color.Black,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(5.dp),
                fontWeight = FontWeight.Light,
                fontSize = 10.sp
            )
            CommonButton(
                text = "Click Me",
                onClick = { showToastState.value= true },
                enabled = isButtonEnabled,
                fontStyle = FontStyle.Italic,
                contentColor = Color.Red,
                backgroundColor = Color.Cyan,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            )
            CommonButton(
                text = "Click Me",
                isLoading = isLoading,
                onClick = {
                    isLoading.value = true
                    showToastState.value= true
                    CoroutineScope(Dispatchers.IO).launch {
                        try {
                            kotlinx.coroutines.delay(2000)
                        } finally {
                            withContext(Dispatchers.Main) {
                                isLoading.value = false
                            }
                        }
                    }
                },
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()
            )
        }
    }
}
private fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    POCReusableComponentsTheme {
        ButtonUi()
    }
}