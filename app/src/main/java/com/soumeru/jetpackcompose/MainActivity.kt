package com.soumeru.jetpackcompose

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CircularAnimatedProgressBar()
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
fun ImageView(modifier: Modifier = Modifier) {

    val painter = painterResource(id = R.drawable.jetpack_compose)
    val contentDescription = "Jetpack Compose"
    val title = "Jetpack Compose"

    Box(
        modifier = Modifier
            .fillMaxSize(0.5f)
            .padding(16.dp)
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

                Box(
                    modifier = Modifier
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
}

@Composable
fun TextViewWithFont() {

    val fontFamily = FontFamily(
        Font(R.font.roboto_condensed_light, FontWeight.Light),
        Font(R.font.roboto_condensed_bold, FontWeight.Bold),
        Font(R.font.roboto_condensed_bold_italic, FontWeight.ExtraBold),
        Font(R.font.roboto_condensed_italic, FontWeight.SemiBold),
        Font(R.font.roboto_condensed_light_italic, FontWeight.ExtraLight),
        Font(R.font.roboto_condensed_regular, FontWeight.Normal)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF05885E))
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(color = Color.Red, fontSize = 50.sp)
                ) {
                    append("J")
                }
                append("etpack ")
                withStyle(
                    style = SpanStyle(color = Color.Red, fontSize = 50.sp)
                ) {
                    append("C")
                }
                append("ompose")
            },
            color = Color.White,
            fontSize = 30.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ColorBox() {
    val color = remember {
        mutableStateOf(Color.Magenta)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .background(Color.Red)
            .weight(1f)
            .fillMaxSize()
            .clickable {
                color.value = Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1f
                )
            }) {
        }

        Box(
            modifier = Modifier
                .background(color.value)
                .weight(1f)
                .fillMaxSize()
        ) {
        }

    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ShowEditTextView() {

    val scaffoldState = rememberScaffoldState()
    var textFieldState by remember {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp)
        ) {
            TextField(
                value = textFieldState,
                label = {
                    Text(text = "Enter your Name")
                },
                onValueChange = {
                    textFieldState = it
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(15.dp))
            Button(onClick = {
                scope.launch {
                    scaffoldState.snackbarHostState.showSnackbar("Hello $textFieldState")
                }
            }) {
                Text(text = "Click")
            }
        }
    }
}

@Composable
fun ListViewInCompose() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        itemsIndexed(
            listOf(
                "A", "N", "D", "R", "O", "I", "D", " ", "J", "E", "T", "P", "A", "C", "K", " ",
                "C", "O", "M", "P", "O", "S", "E"
            )
        ) { index, string ->
            Text(
                text = string,
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )
        }
    }
}

@Composable
fun ConstraintLayoutView() {
    val constraints = ConstraintSet {
        val greenBox = createRefFor("greenBox")
        val redBox = createRefFor("redBox")
        val guidLineA = createGuidelineFromTop(0.5f)
        val guidLineB = createGuidelineFromTop(0.25f)

        constrain(greenBox) {
            top.linkTo(guidLineA)
            start.linkTo(parent.start)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }

        constrain(redBox) {
            top.linkTo(guidLineB)
            start.linkTo(greenBox.end)
            end.linkTo(parent.end)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }

        createHorizontalChain(greenBox, redBox, chainStyle = ChainStyle.Packed)
    }

    ConstraintLayout(
        constraintSet = constraints,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Green)
                .layoutId("greenBox")
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Red)
                .layoutId("redBox")
        )
    }
}

@Composable
fun CircularAnimatedProgressBar() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        val percentage = 0.75f
        val number = 100
        val fontSize: TextUnit = 25.sp
        val radius: Dp = 50.dp
        val color: Color = Color.Magenta
        val strokeWidth: Dp = 8.dp
        val animDuration = 1000
        val animDelay = 0

        var animationPlayed by remember {
            mutableStateOf(false)
        }

        val currentPercentage = animateFloatAsState(
            targetValue = if (animationPlayed) percentage else 0f,
            animationSpec = tween(
                durationMillis = animDuration,
                delayMillis = animDelay
            )
        )
        LaunchedEffect(key1 = true) {
            animationPlayed = true
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.size(radius * 2f)
        ) {
            Canvas(modifier = Modifier.size(radius * 2f)) {
                drawArc(
                    color = color,
                    -90f,
                    360 * currentPercentage.value,
                    useCenter = false,
                    style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)

                )
            }

            Text(
                text = (currentPercentage.value * number).toInt().toString() + "%",
                color = Color.Black,
                fontSize = fontSize,
                fontWeight = FontWeight.SemiBold
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultView() {
    CircularAnimatedProgressBar()
}