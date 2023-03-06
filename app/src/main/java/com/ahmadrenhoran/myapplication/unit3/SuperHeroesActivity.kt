package com.ahmadrenhoran.myapplication.unit3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.animation.*
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.Spring.DampingRatioLowBouncy
import androidx.compose.animation.core.Spring.StiffnessVeryLow
import androidx.compose.animation.core.SpringSpec
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.ahmadrenhoran.myapplication.R
import com.ahmadrenhoran.myapplication.unit3.data.HeroesRepository
import com.ahmadrenhoran.myapplication.unit3.model.Hero
import com.ahmadrenhoran.myapplication.unit3.ui.theme.ComposePracticeTheme

class SuperHeroesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SuperheroesApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SuperheroesApp() {
    val visibleState = remember {
        MutableTransitionState(false).apply {
            // Start the animation immediately.
            targetState = true
        }
    }
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .size(56.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(R.string.superheroes),
                style = MaterialTheme.typography.h1,
            )
        }
    }) {
        AnimatedVisibility(
            visibleState = visibleState,
            enter = fadeIn(
                animationSpec = spring(dampingRatio = Spring.DampingRatioLowBouncy)
            ),
            exit = fadeOut()
        ) {
            LazyColumn(
                modifier = Modifier
                    .padding(16.dp)
                    .background(MaterialTheme.colors.background)
                //                .padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                itemsIndexed(HeroesRepository.heroes) { index, hero ->
                    HeroItem(
                        hero = hero,
                        modifier = Modifier
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                            .animateEnterExit(
                                enter = slideInVertically(
                                    animationSpec = spring(
                                        stiffness = Spring.StiffnessVeryLow,
                                        dampingRatio = Spring.DampingRatioLowBouncy
                                    ),
                                    initialOffsetY = {it * (index + 1)}// staggered entrance
                                )
                            )
                    )
                }
            }
        }
    }
}


@Composable
fun HeroItem(hero: Hero, modifier: Modifier = Modifier) {
    Card(elevation = 2.dp, modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .sizeIn(72.dp)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            HeroInformation(hero = hero, modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.size(16.dp))
            HeroIcon(image = hero.imageRes)
        }
    }
}

@Composable
fun HeroInformation(hero: Hero, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(hero.nameRes),
            style = MaterialTheme.typography.h3
        )
        Text(
            text = stringResource(hero.descriptionRes),
            style = MaterialTheme.typography.body1
        )
    }
}

@Composable
fun HeroIcon(@DrawableRes image: Int) {
    Box(
        modifier = Modifier
            .size(72.dp)
            .clip(RoundedCornerShape(8.dp))
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            alignment = Alignment.TopCenter,
            contentScale = ContentScale.FillWidth
        )
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview13() {
    ComposePracticeTheme {
        SuperheroesApp()
    }
}