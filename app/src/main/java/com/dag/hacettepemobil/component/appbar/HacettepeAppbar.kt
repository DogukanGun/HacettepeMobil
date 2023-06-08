package com.dag.hacettepemobil.component.appbar


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dag.hacettepemobil.R
import com.dag.hacettepemobil.ui.theme.HacettepeMobilTheme

@Composable
fun HacettepeAppbar(
    username:String,
    department:String
){
    TopAppBar(
        title = {},
        navigationIcon = {
             Row{
                 IconButton(
                     onClick = {},
                     content = {
                         Icon(
                             imageVector = Icons.Default.Person,
                             contentDescription = "Person",
                             tint = Color.Red,
                             modifier = Modifier
                                 .padding(12.dp)
                                 .size(48.dp)
                         )
                     }
                 )
                 Column {
                     Text(text = username)
                     Text(text = department)
                 }
             }
        },
        actions = {
            Row(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
            ) {
                IconButton(
                    onClick = {

                    }
                ){
                    Icon(
                        painter = painterResource(
                            id = R.drawable.ic_menu
                        ),
                        contentDescription = "",
                        modifier = Modifier
                            .size(30.dp),
                        tint = Color.Black
                    )
                }
            }
        },
        backgroundColor = Color.White
    )
}

@Composable
@Preview
fun HacettepeAppbarPreview(){
    HacettepeMobilTheme {
        HacettepeAppbar(
            username = "Dogukan",
            department = "Informatics"
        )
    }
}