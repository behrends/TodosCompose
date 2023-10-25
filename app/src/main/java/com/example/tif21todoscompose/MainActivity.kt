package com.example.tif21todoscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.tif21todoscompose.ui.theme.TIF21TodosComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TIF21TodosComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TodosApp()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TodosApp() {
    TodoInput()
}

@Composable
fun TodoInput() {
    TextField(
        value = "",
        onValueChange = {},
        label = { Text(stringResource(R.string.enter_todo)) },
    )
}
