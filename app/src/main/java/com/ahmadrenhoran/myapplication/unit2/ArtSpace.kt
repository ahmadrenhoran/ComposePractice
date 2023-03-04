package com.ahmadrenhoran.myapplication.unit2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmadrenhoran.myapplication.R
import com.ahmadrenhoran.myapplication.unit2.ui.theme.ComposePracticeTheme

class ArtSpace : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    ArtSpaceScreen()
                }
            }
        }
    }


}

@Composable
fun ArtSpaceScreen() {
    var currentIndex by remember {
        mutableStateOf(0)
    }
    /*
    Recomposition terjadi saat variable mutable state mengalami perubahan
    Ketika mengalami perubahan akan dicek semua dari root hingga leaf
    apa saja yang menggunakan variable tersebut, jika menggunakan
    maka akan dilakukan recompose, ketika recompose, jika variable tidak
    menggunakan remember maka nilainya akan hilang, dan jika menggunakan
    keyword remember maka ketika recomposeition, variable tersebut akan
    memempertahankan/mengingat nilainya
     */
    Log.d("onRoot", "Recomposition happen")



    val listUserArt = mutableListOf(
        UserArt("Ahmad", "title 1", image = R.drawable.dice_1, year = "2012"),
        UserArt("Maulana", "title 2", image = R.drawable.dice_2, year = "2012"),
        UserArt("Renhoran", "title 3", image = R.drawable.dice_3, year = "2012"),
        UserArt("Dullahan", "title 4", image = R.drawable.dice_4, year = "2012"),
        UserArt("Eris", "title 5", image = R.drawable.dice_5, year = "2012"),
        UserArt("Amare", "title 6", image = R.drawable.dice_6, year = "2012")
    )

    listUserArt.let {

    }

    listUserArt.apply {

    }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 24.dp, start = 16.dp, bottom = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Image(
            painter = painterResource(listUserArt[currentIndex].image),
            contentDescription = null,
            modifier = Modifier
                .weight(1f)
                .wrapContentSize(Alignment.Center)
                .padding(top = 24.dp)
                .border(BorderStroke(4.dp, Color.Gray))
                .shadow(elevation = 4.dp)

        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            elevation = 10.dp,
        ) {
            Column(
                modifier = Modifier.padding(15.dp)
            ) {
                Text(
                    text = listUserArt[currentIndex].title,
                    fontSize = 28.sp, fontWeight = FontWeight.Light
                )
                Text(
                    buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(fontWeight = FontWeight.W900)
                        ) {
                            append(listUserArt[currentIndex].name)
                        }
                        append(" (${listUserArt[currentIndex].year})")
                    }
                ).also {
                    Log.d("onCard", "Recomposition happen")
                }
            }
        }
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Button(onClick = {
                if (currentIndex != 0) currentIndex--
                else currentIndex = 5
            }, modifier = Modifier.weight(1f)) {
                Text(text = "Previous")
//                    .also {
//                        Log.d("onPreviousText", "Recomposition happen")
//                    }
            }.also {
                Log.d("onPreviousButton", "Recomposition happen")
            }
            Spacer(modifier = Modifier.width(12.dp))
            Button(onClick = {
                if (currentIndex != 5) currentIndex++
                else currentIndex = 0
            }, modifier = Modifier.weight(1f)) {
                Text(text = "Next")
            }

        }
    }
}

data class UserArt(
    val name: String,
    val title: String,
    val year: String,
    val image: Int
)

@Preview(showBackground = true)
@Composable
fun DefaultPreview9() {
    ComposePracticeTheme {
        ArtSpaceScreen()
    }
}