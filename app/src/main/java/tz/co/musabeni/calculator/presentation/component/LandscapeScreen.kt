package tz.co.musabeni.calculator.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import tz.co.musabeni.calculator.presentation.HomeEvent
import tz.co.musabeni.calculator.presentation.HomeState
import tz.co.musabeni.calculator.ui.theme.dimens

@Composable
fun LandscapeScreen(
    modifier: Modifier = Modifier,
    state: HomeState,
    onEvent:(HomeEvent) -> Unit
){

    Row(
        modifier = modifier
        ,
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.small3)
    ) {
        TopSection(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            password = state.password,
            isPortrait = false,
            onEvent = onEvent
        )
        ButtonSection(
            modifier = Modifier
                .weight(1f)
                .padding(MaterialTheme.dimens.small2),
            onEvent = onEvent
        )
    }
}