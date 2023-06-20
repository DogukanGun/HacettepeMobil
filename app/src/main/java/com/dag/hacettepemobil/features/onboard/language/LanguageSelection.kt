package com.dag.hacettepemobil.features.onboard.language

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dag.hacettepemobil.R
import com.dag.hacettepemobil.base.settings.SettingsService
import com.dag.hacettepemobil.component.hacettepebutton.HacettepeButton
import com.dag.hacettepemobil.data.LanguageModel
import com.dag.hacettepemobil.ui.theme.HacettepeMobilTheme
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun LanguageSelection(
    modifier: Modifier,
    settingsService: SettingsService,
    viewModel:LanguageVM = viewModel()
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .fillMaxSize()
    ) {
        Image(
            modifier= Modifier
                .fillMaxWidth(fraction = 0.5f)
                .fillMaxHeight(fraction = 0.2f),
            painter = painterResource(id = R.drawable.ic_permission_2),
            contentDescription = "Halloo"
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.language_title))
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            ) {
                items(settingsService.getLanguages()) { language ->
                    LanguageListItem(
                        languageModel = language,
                        isRowSelected = language == viewModel.selectedLanguage
                    ){
                        viewModel.selectedLanguage = language
                    }
                }
            }
        }
        HacettepeButton(
            modifier = Modifier.padding(vertical = 10.dp),
            buttonText = R.string.okay,
            isEnabled = viewModel.isButtonActive(),
            onClick = {
            }
        )
    }
}

@Composable
fun LanguageListItem(
    languageModel: LanguageModel,
    isRowSelected: Boolean,
    listItemClick: ()->Unit,
){
    Row(
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                modifier= Modifier
                    .fillMaxWidth(fraction = 0.2f)
                    .fillMaxHeight(),
                painter = painterResource(id = languageModel.imageId),
                contentDescription = "Halloo"
            )
            Text(
                modifier = Modifier.fillMaxWidth(fraction = 0.4f),
                text = languageModel.name
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(0.4f),
            horizontalArrangement = Arrangement.End
        ) {
            CustomRadioButton(
                modifier = Modifier,
                selected = isRowSelected
            ) {
                listItemClick()
            }
        }

    }
}

@Composable
fun CustomRadioButton(
    modifier: Modifier,
    selected: Boolean,
    onClick: () -> Unit
) {
    val radioColor = if (selected) Color(3, 11, 119) else Color.Transparent
    val borderColor = Color(194, 205, 220)

    Box(
        modifier = modifier
            .size(24.dp)
            .background(color = borderColor, shape = RoundedCornerShape(12.dp))
            .padding(2.dp)
    ) {
        RadioButton(
            selected = selected,
            onClick = onClick,
            colors = RadioButtonDefaults.colors(
                selectedColor = radioColor,
                unselectedColor = Color.Transparent
            ),
            modifier = Modifier
                .align(Alignment.Center)
        )
    }
}

@Preview
@Composable
fun LanguageSelectionPreview() {
    HacettepeMobilTheme {
        LanguageSelection(
            modifier = Modifier.background(Color.White),
            settingsService = SettingsService()
        )
    }
}