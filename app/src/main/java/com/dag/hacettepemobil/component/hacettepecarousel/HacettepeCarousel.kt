package com.dag.hacettepemobil.component.hacettepecarousel

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dag.hacettepemobil.base.settings.SettingsService
import com.dag.hacettepemobil.data.CarouselItem
import com.dag.hacettepemobil.ui.theme.HacettepeMobilTheme

@Composable
fun HacettepeCarousel(
    items: List<CarouselItem>,
    modifier: Modifier,
) {
    val scrollState = rememberLazyListState()
    val currentItemIndex = remember { mutableStateOf(0) }
    LaunchedEffect(scrollState) {
        snapshotFlow { scrollState.firstVisibleItemIndex }
            .collect { scrollOffset ->
                val newIndex = calculateCurrentItemIndex(scrollOffset.toFloat(), items.size)
                currentItemIndex.value = newIndex
            }
    }

    Column(modifier = modifier) {
        LazyRow(
            modifier = Modifier.fillMaxHeight(fraction = 0.8f).fillMaxWidth(),
            state = scrollState,
            horizontalArrangement = Arrangement.Center
        ) {
            itemsIndexed(items) { index, item ->
                CarouselItem(
                    item = item,
                    modifier = Modifier.fillMaxSize().padding(horizontal = 50.dp)
                )
            }
        }
        DotIndicator(
            itemCount = items.size,
            currentIndex = currentItemIndex.value,
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }
}

fun calculateCurrentItemIndex(scrollOffset: Float, itemCount: Int): Int {
    val maxScroll = (itemCount - 1).toFloat()
    val index = (scrollOffset / maxScroll).toInt()
    return index.coerceIn(0, itemCount - 1)
}

@Composable
fun CarouselItem(item: CarouselItem, modifier: Modifier) {
    Box(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(item.imageId),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Fit
        )
        Text(
            text = stringResource(id = item.textId),
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.BottomStart),
            color = Color.Gray
        )
    }
}


@Composable
fun DotIndicator(
    itemCount: Int,
    currentIndex: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(itemCount) { index ->
            val color = if (index == currentIndex) Color.Black else Color.Gray
            Box(
                modifier = Modifier
                    .size(20.dp)
                    .padding(4.dp)
                    .clip(CircleShape)
                    .background(color = color)
            )
        }
    }
}

@Preview
@Composable
fun CarouselPreview() {
    HacettepeMobilTheme {
        HacettepeCarousel(
            items = SettingsService().getCarouselItems(),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.White),
        )
    }
}
