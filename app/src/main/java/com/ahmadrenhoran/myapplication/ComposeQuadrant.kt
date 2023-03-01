package com.ahmadrenhoran.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ahmadrenhoran.myapplication.ui.theme.ComposePracticeTheme

class ComposeQuadrant : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    ComposeQuadrantLayout()
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrantLayout() {
    Column(Modifier.fillMaxWidth()) {
        Row(modifier = Modifier.weight(1f)) {
            ComposeCard(
                title = "Text composable",
                text = "Displays text and follows Material Design guidelines.",
                colors = Color.Green,
                modifier = Modifier.weight(1f)
            )
            ComposeCard(
                title = "Text composable",
                text = "Displays text and follows Material Design guidelines.",
                colors = Color.Yellow,
                modifier = Modifier.weight(1f)
            )
        }
        Row(modifier = Modifier.weight(1f)) {
            ComposeCard(
                title = "Text composable",
                text = "Displays text and follows Material Design guidelines.",
                colors = Color.Cyan,
                modifier = Modifier.weight(1f)
            )
            ComposeCard(
                title = "Text composable",
                text = "Displays text and follows Material Design guidelines.",
                colors = Color.LightGray,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun ComposeCard(title: String, text: String, colors: Color, modifier: Modifier) {
    Column(
        modifier = modifier
            .background(color = colors)
            .fillMaxSize()
            .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(text = text, textAlign = TextAlign.Justify)
    }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview4() {
    ComposePracticeTheme {
        ComposeQuadrantLayout()
    }
}