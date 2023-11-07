package com.example.tif21todoscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    Todos()
}

@Composable
fun Todos() {
    var todos by remember { mutableStateOf(listOf(Todo("Sport"), Todo("Einkaufen"), Todo("Kotlin lernen"))) }
    Column {
        TodoInput(onSave = {todos = todos + Todo(it)})
        LazyColumn(modifier = Modifier.padding(16.dp).fillMaxSize()) {
            items(todos) { TodoItem(it) }
        }
    }
}

@Composable
fun TodoInput(onSave: (String) -> Unit) {
    // by ist ein Delegate auf die Eigenschaft value
    // var todo = remember { mutableStateOf("") }
    var todo by remember { mutableStateOf("") }
    Row {
        TextField(
            value = todo, // ohne by: value = todo.value
            onValueChange = { todo = it },
            label = { Text(stringResource(R.string.enter_todo)) },
        )
        Spacer(modifier = Modifier.width(16.dp))
        Button(onClick = {onSave(todo)})  {
            Text(stringResource(R.string.save))
        }
    }
}

@Composable
fun TodoItem(todo: Todo) {
    var done by remember { mutableStateOf(false) }
    val style = TextStyle(textDecoration = if (done) TextDecoration.LineThrough else TextDecoration.None)
    Text(text = todo.text,
        modifier = Modifier.clickable(onClick = {done = !done}).padding(8.dp).fillMaxSize(),
        style = style)
}