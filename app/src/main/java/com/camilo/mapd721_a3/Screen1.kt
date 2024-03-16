package com.camilo.mapd721_a3


import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Screen1(navController: NavController) {
    var count by remember { mutableStateOf(0) }

    Button(onClick = { count++ }) {
        Text("Increment")
    }

    AnimatedContent(
        targetState = count,
        transitionSpec = {
            if (targetState > initialState) {
                slideInVertically { height -> height } + fadeIn() with
                        slideOutVertically { height -> -height } + fadeOut()
            } else {
                slideInVertically { height -> -height } + fadeIn() with
                        slideOutVertically { height -> height } + fadeOut()
            }.using(SizeTransform(clip = false))
        }, label = ""
    ) { targetCount ->
        Text(text = "Count: $targetCount")
    }

    Button(onClick = { navController.navigate("main") }) {
        Text("Go back")
    }
}