package com.soumeru.jetpackcompose

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val painter = painterResource(id = R.drawable.jetpack_compose)
            val description = "Jetpack Compose"
            val title = "Jetpack Compose"
            Box(
                modifier = Modifier
                    .fillMaxSize(0.5f)
                    .padding(16.dp)
            ) {
                ImageView(
                    painter,
                    description,
                    title
                )
            }
        }
    }
}

@Composable
fun ColumnView() {
    Column(
        modifier = Modifier
            .fillMaxSize(0.5f)
            .background(color = Color.Magenta)
            .fillMaxHeight(0.5f)
            .padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Hello", modifier = Modifier.clickable {
            // showToast(context = LocalContext.current, "Clicked!")
        })
        Spacer(modifier = Modifier.height(10.dp))
        Text("Jetpack", modifier = Modifier.padding(start = 30.dp, top = 10.dp))
    }
}

fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

@Composable
fun RowView() {
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

@Composable
fun ImageView(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {

        Box(modifier = Modifier.height(200.dp)) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ), startY = 300f
                    )
                )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(text = title, style = TextStyle(color = Color.White), fontSize = 16.sp)
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun DefaultView() {
    val painter = painterResource(id = R.drawable.jetpack_compose)
    val description = "Jetpack Compose"
    val title = "Jetpack Compose"
    Box(
        modifier = Modifier
            .fillMaxSize(0.5f)
            .padding(16.dp)
    ) {
        ImageView(painter = painter, contentDescription = description, title = title)
    }
}