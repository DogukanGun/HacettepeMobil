package com.dag.hacettepemobil.features.onboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dag.hacettepemobil.navigation.NavGraph
import com.dag.hacettepemobil.navigation.NavScreen
import com.dag.hacettepemobil.ui.theme.HacettepeMobilTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnboardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HacettepeMobilTheme {
                NavGraph(
                    startDestination = NavScreen.OnboardScreen.route,
                    isOnboard = true
                )
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    HacettepeMobilTheme {
        Greeting2("Android")
    }
}