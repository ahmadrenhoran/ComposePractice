package com.ahmadrenhoran.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmadrenhoran.myapplication.ui.theme.ComposePracticeTheme


class CardName : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background
                ) {
                    CardNameLayout(
                        "Jennifer Doe",
                        "Android Developer Extraordinaire",
                        "+62 666 1111 5555",
                        "@AndroidDev",
                        "jen.doe@android.com"
                    )
                }
            }
        }
    }
}

@Composable
fun CardNameLayout(name: String, title: String, noHp: String, social: String, email: String) {
    Column(
        Modifier
            .background(color = Color.Black)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.weight(1f).fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.android_logo),
                contentDescription = null,
                modifier = Modifier.height(128.dp).width(128.dp)
            )
            Text(text = name, color = Color.White, fontSize = 48.sp, fontWeight = FontWeight.Light)
            Text(text = title, color = Color(0xFF3ddc84), fontWeight = FontWeight.Bold)
        }

        Column(
            Modifier
                .weight(0.5f)
                .padding(bottom = 24.dp),
            verticalArrangement = Arrangement.Bottom
        ) {

            LogoAndContact(
                painter = painterResource(R.drawable.ic_baseline_phone), info = noHp
            )

            LogoAndContact(
                painter = painterResource(R.drawable.ic_baseline_social), info = social
            )
            LogoAndContact(
                painter = painterResource(R.drawable.ic_baseline_email), info = email
            )
        }
    }
}

@Composable
fun LogoAndContact(painter: Painter, info: String) {
    Spacer(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(color = Color.White)
    )
    Row(
        Modifier
            .background(Color.Black)
            .padding(top = 8.dp, bottom = 8.dp, start = 32.dp)
    ) {

        Icon(
            painter = painter, contentDescription = null, tint = Color(0xFF3ddc84)
        )
        Spacer(modifier = Modifier.padding(12.dp))
        Text(text = info, color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    ComposePracticeTheme {
        CardNameLayout(
            "Jennifer Doe",
            "Android Developer Extraordinaire",
            "+62 666 1111 5555",
            "@AndroidDev",
            "jen.doe@android.com"
        )

    }
}