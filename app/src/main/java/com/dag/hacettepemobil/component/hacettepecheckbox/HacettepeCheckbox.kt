package com.dag.hacettepemobil.component.hacettepecheckbox

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dag.hacettepemobil.ui.theme.HacettepeMobilTheme

@Composable
fun HacettepeCheckbox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    size: Dp = 24.dp,
) {
    val clickedColor = Color(0xFF030B77)
    val notClickedColor = Color.White

    Box(
        modifier = Modifier
            .size(size)
            .clickable { onCheckedChange(!checked) },
        contentAlignment = androidx.compose.ui.Alignment.Center,
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = null, // We handle it via the Box's onClick
            colors = CheckboxDefaults.colors(
                checkedColor = clickedColor,
                uncheckedColor = notClickedColor,
                checkmarkColor = Color.White,
            ),
            modifier = Modifier
                .size(size)
                .border(2.dp, Color.Black, RoundedCornerShape(4.dp))
        )
    }

}

@Composable
@Preview
fun HacettepeCheckboxPreview() {
    var clickState by mutableStateOf(false)
    HacettepeMobilTheme {
        HacettepeCheckbox(
            checked = clickState,
            onCheckedChange = {
                clickState = it
            }
        )
    }
}