package com.soumeru.jetpackcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize(0.5f)
                    .background(color = Color.Magenta)
                    .fillMaxHeight(0.5f)
                    .padding(50.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Hello", modifier = Modifier.clickable {
                    Toast.makeText(applicationContext, "Clicked!", Toast.LENGTH_SHORT).show()
                })
                Spacer(modifier = Modifier.height(10.dp))
                Text("Jetpack", modifier = Modifier.padding(start = 30.dp, top = 10.dp))
            }

            /*Row(
                modifier = Modifier
                    .fillMaxSize(0.5f)
                    .background(color = Color.Cyan),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,

            ) {
                Text("Hello")
                Text("Jetpack")
            }*/
        }
    }
}