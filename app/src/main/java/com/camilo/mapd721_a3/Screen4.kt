package com.camilo.mapd721_a3

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlin.math.roundToInt


@Composable
fun Screen4(navController: NavController) {
    var offsetX by remember { mutableStateOf(0f) }
    var offsetY by remember { mutableStateOf(0f) }

    val size = 100.dp

    // Create a draggable box with a specified size and background color
    Surface {
        Box(
            Modifier
                .size(size)
                .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
                .background(Color.Red)
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        // Update the offset based on the drag amount
                        offsetX += dragAmount.x
                        offsetY += dragAmount.y
                    }
                }
        )
        Button(onClick = { navController.navigate("main") }) {
            Text("Go back")
        }
    }
}

