package com.camilo.mapd721_a3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.camilo.mapd721_a3.ui.theme.MAPD721A3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MAPD721A3Theme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun MainScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { navController.navigate("screen1") }, modifier = Modifier.padding(8.dp)) {
            Text("Screen 1 Animated Content")
        }
        Button(onClick = { navController.navigate("screen2") }, modifier = Modifier.padding(8.dp)) {
            Text("Screen 2 Value Based Animation:")
        }
        Button(onClick = { navController.navigate("screen3") }, modifier = Modifier.padding(8.dp)) {
            Text("Screen 3 Value Based Animation 2")
        }
        Button(onClick = { navController.navigate("screen4") }, modifier = Modifier.padding(8.dp)) {
            Text("Screen 4 Gesture Based Animation")
        }

        Divider()
        Text(text = "301240077", fontWeight = FontWeight.Bold)
        Text(text = "Camilo Meli", fontWeight = FontWeight.Bold)
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "main") {
        composable("main") { MainScreen(navController) }
        composable("screen1") { Screen1(navController) }
        composable("screen2") { Screen2(navController) }
        composable("screen3") { Screen3(navController) }
        composable("screen4") { Screen4(navController) }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MAPD721A3Theme {
        Greeting("Android")
    }
}