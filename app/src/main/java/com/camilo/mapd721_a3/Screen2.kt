package com.camilo.mapd721_a3

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController


@Composable
fun Screen2(navController: NavController) {
    var visible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { visible = !visible }) {
            Text(if (visible) "Hide" else "Show")
        }
        AnimatedVisibility(
            visible = visible,
            enter = expandVertically() + fadeIn(initialAlpha = 0.3f),
            exit = shrinkVertically() + fadeOut()
        ) {
            Text(stringResource(R.string.lorem))
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = { navController.navigate("main") }) {
            Text("Go back")
        }
    }
}

