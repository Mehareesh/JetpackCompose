package com.soumeru.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /*Column(
                modifier = Modifier
                    .fillMaxSize(0.5f)
                    .background(color = Color.Magenta),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Jetpack Compose")
                Text("Welcome Jetpack")
            }*/

            Row(
                modifier = Modifier
                    .fillMaxSize(0.5f)
                    .background(color = Color.Cyan),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,

            ) {
                Text("Hello")
                Text("Jetpack")
            }
        }
    }
}