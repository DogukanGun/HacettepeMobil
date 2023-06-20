package com.dag.hacettepemobil.component.hacettepebutton

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
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
    val primaryColor = Brush.horizontalGradient(
        colors = listOf(Color(0xFF007CEF), Color(0xFF0007A5)),
        startX = 0f,
        endX = Float.POSITIVE_INFINITY
    )
    val secondaryColor = Brush.horizontalGradient(
        colors = listOf(Color.White,Color.Gray.copy(alpha = 0.3f)),
        startX = 0f,
        endX = Float.POSITIVE_INFINITY
    )

    TextButton(
        modifier = modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(10.dp)
            .clip(RoundedCornerShape(32.5.dp))
            .background(
                brush = if(isPrimary) primaryColor else secondaryColor
            ),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent,
            disabledBackgroundColor = Color.Gray
        ),
        onClick = onClick,
        elevation = ButtonDefaults.elevation(0.dp),
        enabled = isEnabled
    ) {
        Text(
            text = stringResource(id = buttonText),
            color = if(isPrimary) Color.White else Color.Black,
        )
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

@Preview(showBackground = true)
@Composable
fun HacettepeButtonDisabledPreview() {
    HacettepeMobilTheme {
        HacettepeButton(
            modifier = Modifier,
            buttonText = R.string.app_name,
            isPrimary = true,
            isEnabled = false,
            onClick = {}
        )
    }
}