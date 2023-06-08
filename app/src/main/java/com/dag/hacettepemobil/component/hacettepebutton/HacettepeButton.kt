package com.dag.hacettepemobil.component.hacettepebutton

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
            .padding(10.dp),
        shape = RoundedCornerShape(50),
        colors = ButtonDefaults.buttonColors(backgroundColor =  if (isPrimary) Color.Blue else Color.Red),
        onClick = onClick,
        enabled = isEnabled
    ){
        Text(
            text = stringResource(id = buttonText),
            color = Color.White
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