package com.dag.hacettepemobil.component.hacettepefield

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
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
    placeholder:String = "",
    modifier: Modifier
){
    Column(
        modifier = modifier.padding(top = 16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = stringResource(id = labelId),
            style = MaterialTheme.typography.h3,
        )
        TextField(
            value = value.value,
            textStyle = MaterialTheme.typography.body1,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = MaterialTheme.colors.primary,
                textColor = MaterialTheme.colors.primary
            ),
            onValueChange = { newValue:String -> onValueChange(newValue) },
            placeholder = { Text(text = placeholder)},
            shape = RoundedCornerShape(50),
            modifier = modifier
                .height(50.dp)
                .padding(top = 8.dp)
                .fillMaxWidth(1f)
                .shadow(
                    elevation = 5.dp,
                    shape = RoundedCornerShape(25.dp)
                )
                .border(
                    BorderStroke(1.dp, Color(0xFF0070D7)),
                    shape = RoundedCornerShape(25.dp)
                ),
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