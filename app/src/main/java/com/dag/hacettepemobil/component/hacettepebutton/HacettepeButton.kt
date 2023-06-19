package com.dag.hacettepemobil.component.hacettepebutton

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dag.hacettepemobil.R
import com.dag.hacettepemobil.ui.theme.HacettepeMobilTheme


@Composable
fun HacettepeButton(
    modifier: Modifier,
    isEnabled: Boolean = true,
    buttonText: Int,
    isPrimary: Boolean = true,
    onClick: () -> Unit
) {


    TextButton(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color.Transparent)
            .padding(10.dp)
            .clip(RoundedCornerShape(32.5.dp)),
        shape = RoundedCornerShape(50),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent,
            contentColor = Color.White
        ),        onClick = onClick,
        elevation = ButtonDefaults.elevation(0.dp),
        enabled = isEnabled
    ){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color(0xFF007CEF), Color(0xFF0007A5)),
                        startX = 0f,
                        endX = Float.POSITIVE_INFINITY
                    )
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = stringResource(id = buttonText),
                color = Color.White
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun HacettepeButtonPrimaryPreview() {
    HacettepeMobilTheme {
        HacettepeButton(
            modifier = Modifier,
            buttonText = R.string.app_name,
            isPrimary = true,
            onClick = {}
        )
    }
}


@Preview(showBackground = true)
@Composable
fun HacettepeButtonSecondaryPreview() {
    HacettepeMobilTheme {
        HacettepeButton(
            modifier = Modifier,
            buttonText = R.string.app_name,
            isPrimary = false,
            onClick = {}
        )
    }
}