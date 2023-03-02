package com.ahmadrenhoran.myapplication.unit2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmadrenhoran.myapplication.R
import com.ahmadrenhoran.myapplication.unit2.ui.theme.ComposePracticeTheme

class ClickBehavior : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    var currentTap by remember {
        mutableStateOf(1)
    }
    var stepTwoTap by remember {
        mutableStateOf(0)
    }

    when (currentTap) {
        1 -> LemonAndText(
            text = "Tap the lemon tree to select a lemon",
            image = R.drawable.lemon_tree,
            onClickImage = {
                stepTwoTap = (2..4).random()
                currentTap++

            })
        2 -> LemonAndText(
            text = "Keep tapping the lemon to squeeze it",
            image = R.drawable.lemon_squeeze,
            onClickImage = {
//                val rand = (2..4).random()
//                stepTwoTap++
                stepTwoTap--
                if (stepTwoTap == 0) currentTap++
            })
        3 -> LemonAndText(
            text = "Tap the lemonade to drink it",
            image = R.drawable.lemon_drink,
            onClickImage = { currentTap++ })
        4 -> LemonAndText(
            text = "Tap the empty glass to start again",
            image = R.drawable.lemon_restart,
            onClickImage = { currentTap = 1 })
    }


}

@Composable
fun LemonAndText(text: String, image: Int, onClickImage: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = text, fontSize = 18.sp)
        Spacer(modifier = Modifier.padding(16.dp))
        Image(
            painter = painterResource(image),
            contentDescription = null,
            modifier = Modifier
                .clip(RoundedCornerShape(3.dp))
                .border(BorderStroke(2.dp, Color(105, 205, 216)))
                .padding(12.dp)
                .clickable(
                    onClick = onClickImage
                )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview7() {
    ComposePracticeTheme {
        Greeting()
    }
}