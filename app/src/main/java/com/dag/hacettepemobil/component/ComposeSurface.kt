package com.dag.hacettepemobil.component

import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun HacettepeSurface(
    appbar: @Composable () -> Unit,
    bottomBar: @Composable () -> Unit,
    backgroundColor: Color,
    content: @Composable () -> Unit
){
    Scaffold(
        topBar = appbar,
        bottomBar = bottomBar,
        backgroundColor = backgroundColor
    ) {
        Surface {
            content()
        }
    }
}