package com.ahmadrenhoran.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmadrenhoran.myapplication.ui.theme.ComposePracticeTheme

class HappyBirthDayCard : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HappyBirthdayCard("Ahmad", "Someone")
                }
            }
        }
    }

}

@Composable
fun HappyBirthdayCard(from: String, to: String) {
    Box {
        Image(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentScale = ContentScale.Crop,
            painter = painterResource(R.drawable.img),
            contentDescription = "This is background image"
        )
        Column {
            Text(
                text = String.format(stringResource(R.string.happy_birthday), to),
                color = Color.Black,
                fontSize = 28.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(CenterHorizontally)
                    .padding(start = 16.dp, end = 16.dp)
            )
            Text(
                text = String.format(stringResource(R.string.from), from),
                color = Color.Black,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(CenterHorizontally)
                    .padding(start = 16.dp, end = 16.dp),
                fontSize = 24.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePracticeTheme {
        HappyBirthdayCard("Ahmad", "Someone")
    }
}