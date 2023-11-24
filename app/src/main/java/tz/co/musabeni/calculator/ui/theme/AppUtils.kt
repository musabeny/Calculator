package tz.co.musabeni.calculator.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalConfiguration

@Composable
fun AppUtils(
    appDimens: Dimens,
    content:@Composable ()-> Unit
){

    val appDim = remember {
        appDimens
    }

    CompositionLocalProvider(localAppDimens provides appDim) {
        content()
    }
}

val localAppDimens = compositionLocalOf {
    CompactDimens
}

val ScreenOrientation
@Composable
get() = LocalConfiguration.current.orientation