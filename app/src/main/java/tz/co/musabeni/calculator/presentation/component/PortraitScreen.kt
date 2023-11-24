package tz.co.musabeni.calculator.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import tz.co.musabeni.calculator.presentation.HomeEvent
import tz.co.musabeni.calculator.presentation.HomeState
import tz.co.musabeni.calculator.ui.theme.dimens

@Composable
fun PortraitScreen(
    modifier: Modifier = Modifier,
    state: HomeState,
    onEvent:(HomeEvent) -> Unit
){

    Column(
        modifier = modifier
        ,
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.small3)
    ) {
        TopSection(
            modifier = Modifier
                .fillMaxHeight(0.4f),
            password = state.password,
            onEvent = onEvent
        )
        ButtonSection(
            modifier = Modifier
                .fillMaxSize()
                .padding(MaterialTheme.dimens.small2),
            onEvent = onEvent
        )
    }
}