package com.dag.hacettepemobil.component.hacettepefield

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dag.hacettepemobil.R
import com.dag.hacettepemobil.ui.theme.HacettepeMobilTheme

@Composable
fun HacettepeField(
    value: MutableState<String>,
    onValueChange: (String) -> Unit,
    labelId: Int,
    modifier: Modifier
){
    Column(
        modifier = modifier
            .padding(5.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = stringResource(id = labelId))
        TextField(
            value = value.value,
            onValueChange = { newValue:String -> onValueChange(newValue) },
            placeholder = { Text(text = stringResource(id = labelId))},
            shape = RoundedCornerShape(50),
            modifier = modifier
                .padding(top=20.dp,bottom=20.dp,end=20.dp)
        )
    }

}

@Composable
@Preview
fun HacettepeFieldPreview(){
    val textState = remember { mutableStateOf("") }
    HacettepeMobilTheme {
        HacettepeField(
            value = textState,
            labelId = R.string.app_name,
            onValueChange = {
                textState.value = it
            },
            modifier = Modifier
                .background(Color.White)
        )
    }
}